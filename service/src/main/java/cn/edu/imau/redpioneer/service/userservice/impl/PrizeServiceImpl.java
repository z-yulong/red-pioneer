package cn.edu.imau.redpioneer.service.userservice.impl;

import cn.edu.imau.redpioneer.dao.PrizeMapper;
import cn.edu.imau.redpioneer.entity.ActivistPrizeInfo;
import cn.edu.imau.redpioneer.entity.Prize;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.service.userservice.PrizeService;
import cn.edu.imau.redpioneer.utils.FileUtil;
import cn.edu.imau.redpioneer.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author: zyl
 * @date 2022/1/1 16:01
 */
@Service
public class PrizeServiceImpl implements PrizeService {

    @Autowired
    PrizeMapper prizeMapper;
    /**
     * 添加奖惩信息
     * @param prizeImg
     * @param prizeTime
     * @param info
     * @param request
     * @return
     * @throws IOException
     */
    @Override
    public ResultVO addprize(MultipartFile prizeImg, Date prizeTime, String info, ServletRequest request) throws IOException {

        //从header中获取token
        HttpServletRequest req= (HttpServletRequest) request;
        String token = req.getHeader("Authorization");

        //获取文件保存路径
        String savePath = FileUtil.uploadAvater(prizeImg);

        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        Prize prize = new Prize();
        prize.setProve(savePath); //证明材料url
        prize.setPrizeInfo(info); //奖惩信息
        prize.setPrizeTime(prizeTime); //奖惩时间
        prize.setActivistId(id);  //用户表主键

        int i = prizeMapper.insert(prize);

        if (i == 1){
            return new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);


    }

    /**
     * 通过id获取用户奖惩信息
     * @param request
     * @return
     */
    @Override
    public ResultVO getPrize(ServletRequest request) {

        //从header中获取token
        HttpServletRequest req= (HttpServletRequest) request;
        String token = req.getHeader("Authorization");

        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        List<ActivistPrizeInfo> prizeInfos = prizeMapper.selectActivistPrize(id);

        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(),prizeInfos);
    }

}
