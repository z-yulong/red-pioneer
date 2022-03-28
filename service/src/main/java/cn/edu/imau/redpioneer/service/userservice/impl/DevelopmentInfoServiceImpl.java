package cn.edu.imau.redpioneer.service.userservice.impl;

import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.dao.DevelopmentInfoMapper;

import cn.edu.imau.redpioneer.dto.ActivistDevelopmentDto;
import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.entity.DevelopmentInfo;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.enums.State;
import cn.edu.imau.redpioneer.service.userservice.DevelopmentInfoService;
import cn.edu.imau.redpioneer.utils.FileUtil;
import cn.edu.imau.redpioneer.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author: zyl
 * @date 2021/12/30 13:32
 */
@Service
public class DevelopmentInfoServiceImpl implements DevelopmentInfoService {

    private FileUtil fileUtil;
    private ActivistMapper activistMapper;
    private DevelopmentInfoMapper developmentInfoMapper;
    @Autowired
    public DevelopmentInfoServiceImpl(FileUtil fileUtil, ActivistMapper activistMapper, DevelopmentInfoMapper developmentInfoMapper) {
        this.fileUtil = fileUtil;
        this.activistMapper = activistMapper;
        this.developmentInfoMapper = developmentInfoMapper;
    }


    /**
     * 通过姓名或账号查询用户发展信息
     * @param info
     * @return
     */
    @Override
    public ResultVO getDevelopmentInfo(String info) {
        ActivistDevelopmentDto developmentInfo = developmentInfoMapper.selectDevelopmentInfoByName(info);
        if(null == developmentInfo){
            ActivistDevelopmentDto developmentInfo1 = developmentInfoMapper.selectDevelopmentInfoByAccount(info);
            return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), developmentInfo1);
        }
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), developmentInfo);
    }

    /**
     * 通过id获取所有发展信息
     * @param id
     * @return
     */
    @Override
    public ResultVO getDevelopmentInfoById(Integer id) {

        Example example=new Example(DevelopmentInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activistId",id);
        List<DevelopmentInfo> developmentInfos = developmentInfoMapper.selectByExample(example);
        return new ResultVO(ResStatus.OK.getValue(),ResStatus.OK.getText(), developmentInfos);
    }

    @Override
    public ResultVO deleteDevelopmentById(Integer id) {
        int i =developmentInfoMapper.deleteByPrimaryKey(id);

        if (i == 1){
            return new ResultVO(ResStatus.DELETE_OK.getValue(), ResStatus.DELETE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }

    @Override
    public ResultVO uploadDiploma(Date upactivistTime, MultipartFile diploma, ServletRequest request) throws IOException {
        //从header中获取token
        HttpServletRequest req= (HttpServletRequest) request;
        String token = req.getHeader("Authorization");
        //获取文件保存路径
        String diplomaPATH = fileUtil.uploadImg(diploma);

        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        DevelopmentInfo developmentInfo = new DevelopmentInfo();
        developmentInfo.setActivistId(id); //设置用户id
        developmentInfo.setDiploma(diplomaPATH); //积极分子结业证路径
        developmentInfo.setUpactivistTime(upactivistTime); //确定为积极分子时间

        //更新状态为 待审批 (1)
        developmentInfo.setStateCode(State.PENDING.getValue());

        Example example = new Example(DevelopmentInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activistId",id);

        int i = developmentInfoMapper.updateByExampleSelective(developmentInfo, example);
        if(i == 2){
            //成功
            return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }

    @Override
    public ResultVO uploadApplication(Date applicationTime, MultipartFile applicationForm, ServletRequest request) throws IOException {
        //从header中获取token
        HttpServletRequest req= (HttpServletRequest) request;
        String token = req.getHeader("Authorization");
        //获取文件保存路径
        String applicationFormPATH = fileUtil.uploadImg(applicationForm);

        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        DevelopmentInfo developmentInfo =new DevelopmentInfo();
        developmentInfo.setActivistId(id); //设置用户id
        developmentInfo.setApplicationForm(applicationFormPATH); //设置入党申请书路径
        developmentInfo.setApplicationTime(applicationTime); //设置入党申请时间

        //更新状态为 待审批 (1)
        developmentInfo.setStateCode(State.PENDING.getValue());

        int i = developmentInfoMapper.insert(developmentInfo);

        if(i == 1){
            //成功
            return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }

    /**
     * 上传发展信息
     * @param applicationTime 入党申请时间
     * @param applicationForm 入党申请书
     * @param upactivistTime 成为积极分子时间
     * @param diploma 积极分子结业证
     * @param request
     * @return
     * @throws IOException
     */
    @Override
    public ResultVO uploadRdsq(Date applicationTime,
                               MultipartFile applicationForm,
                               Date upactivistTime,
                               MultipartFile diploma,
                               ServletRequest request) throws IOException
    {
        //从header中获取token
        HttpServletRequest req= (HttpServletRequest) request;
        String token = req.getHeader("Authorization");
        //获取文件保存路径
        String applicationFormPATH = fileUtil.uploadImg(applicationForm);
        String diplomaPATH = fileUtil.uploadImg(diploma);

        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        DevelopmentInfo developmentInfo =new DevelopmentInfo();
        developmentInfo.setActivistId(id); //设置用户id (此记录属于谁)
        developmentInfo.setApplicationForm(applicationFormPATH); //设置入党申请书路径
        developmentInfo.setApplicationTime(applicationTime); //设置入党申请时间
        developmentInfo.setDiploma(diplomaPATH); //积极分子结业证路径
        developmentInfo.setUpactivistTime(upactivistTime); //确定为积极分子时间

        //更新状态为 待审批 (1)
        developmentInfo.setStateCode(State.PENDING.getValue());

            int i = developmentInfoMapper.insert(developmentInfo);

            if(i == 1){
                //更新成功
                return new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null);
            }
            return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }
}
