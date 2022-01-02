package cn.edu.imau.redpioneer.service.userservice.impl;

import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.dao.DevelopmentInfoMapper;
import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.entity.ActivistDevelopmentInfo;
import cn.edu.imau.redpioneer.entity.DevelopmentInfo;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.enums.ResultVO;
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

import static cn.edu.imau.redpioneer.utils.FileUtil.deleteFile;

/**
 * @author: zyl
 * @date 2021/12/30 13:32
 */
@Service
public class DevelopmentInfoServiceImpl implements DevelopmentInfoService {
    @Autowired
    ActivistMapper activistMapper;

    @Autowired
    DevelopmentInfoMapper developmentInfoMapper;


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
        String applicationFormPATH = FileUtil.uploadAvater(applicationForm);
        String diplomaPATH = FileUtil.uploadAvater(diploma);

        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        DevelopmentInfo developmentInfo=new DevelopmentInfo();
        developmentInfo.setActivistId(id);
        developmentInfo.setApplicationForm(applicationFormPATH);
        developmentInfo.setApplicationTime(applicationTime);
        developmentInfo.setDiploma(diplomaPATH);
        developmentInfo.setUpactivistTime(upactivistTime);

        int i = developmentInfoMapper.insert(developmentInfo);

        if(i == 1){
            //更新成功
            return new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }

    /**
     * 通过姓名或账号查询用户发展信息
     * @param info
     * @return
     */
    @Override
    public ResultVO getDevelopmentInfo(String info) {

        ActivistDevelopmentInfo developmentInfo = developmentInfoMapper.selectDevelopmentInfoByName(info);

        if(null == developmentInfo){
            ActivistDevelopmentInfo developmentInfo1 = developmentInfoMapper.selectDevelopmentInfoByAccount(info);
            return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), developmentInfo1);
        }
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), developmentInfo);

    }
}
