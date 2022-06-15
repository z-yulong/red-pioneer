package cn.edu.imau.redpioneer.service.commonservice.impl;

import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.service.commonservice.UpdateActivistService;

import cn.edu.imau.redpioneer.utils.FileUtil;
import cn.edu.imau.redpioneer.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: zyl
 * @date 2021/11/10 21:55
 */
@Service
public class UpdateActivistServiceImpl implements UpdateActivistService {

    private FileUtil fileUtil;
    private ActivistMapper activistMapper;
    @Autowired
    public UpdateActivistServiceImpl(FileUtil fileUtil, ActivistMapper activistMapper) {
        this.fileUtil = fileUtil;
        this.activistMapper = activistMapper;
    }

    /**
     * 修改个人信息
     * @param activist
     * @return
     */
    @Override
    public ResultVO updateActivistInfo(Activist activist,HttpServletRequest request) {
        //从header中获取token
        HttpServletRequest req= (HttpServletRequest) request;
        String token = req.getHeader("Authorization");
        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));
        activist.setId(id);

        //根据主键更新不为null的值
        int i = activistMapper.updateByPrimaryKeySelective(activist);

        if(i == 1){
            //更新成功
           return new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), activist);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), activist);
    }

    /**
     * 修改头像
     * @param avatar
     * @param request
     * @return
     * @throws IOException
     */
    @Override
    public ResultVO updateActivistAvatar(MultipartFile avatar, ServletRequest request) throws IOException {

        //从header中获取token
        HttpServletRequest req= (HttpServletRequest) request;
        String token = req.getHeader("Authorization");

        //获取文件保存路径
        String savePath = fileUtil.uploadImg(avatar);

        //从token中获取当前用户账号
        String account= JWTUtil.getAccount(token);

        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        //通过账号查询当前用户信息
        Example example = new Example(Activist.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("account",account);
        Activist activist = activistMapper.selectOneByExample(example);

        //删除旧的头像
        fileUtil.deleteFile(activist.getPhoto());

        //更新头像
        activist.setPhoto(savePath);
        int i = activistMapper.updateByPrimaryKey(activist);
        if(i == 1){
            //更新成功
            return new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null);
        }
            return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);


    }




}
