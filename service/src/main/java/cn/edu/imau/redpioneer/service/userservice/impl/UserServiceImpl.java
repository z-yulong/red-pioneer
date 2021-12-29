package cn.edu.imau.redpioneer.service.userservice.impl;

import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.dao.PrizeMapper;
import cn.edu.imau.redpioneer.dao.ScoreMapper;
import cn.edu.imau.redpioneer.entity.Prize;
import cn.edu.imau.redpioneer.entity.Score;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.service.userservice.UserService;
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
 * @date 2021/12/11 12:44
 */
@Service
public class UserServiceImpl implements UserService {
    private static final  String YES = "1";
    private static final  String NO = "2";

    @Autowired
    ActivistMapper activistMapper;
    @Autowired
    PrizeMapper prizeMapper;

    @Autowired
    ScoreMapper scoreMapper;

    /**
     * 添加奖惩信息
     * @param prizeImg
     * @param date
     * @param level
     * @param request
     * @return
     * @throws IOException
     */
    @Override
    public ResultVO addprize(MultipartFile prizeImg, Date date, String level, ServletRequest request) throws IOException {

        //从header中获取token
        HttpServletRequest req= (HttpServletRequest) request;
        String token = req.getHeader("Authorization");

        //获取文件保存路径
        String savePath = FileUtil.uploadAvater(prizeImg);

        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        Prize prize = new Prize();
        prize.setActivistId(id);
        prize.setPrizeInfo(savePath);
//        prize.setPrizeDate(date);
//        prize.setPrizeLevel(level);
        prizeMapper.insert(prize);

        return new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null);
    }

    /**
     * 获取奖惩信息
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

        Example example = new Example(Prize.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activistId",id);

        List<Prize> prizes = prizeMapper.selectByExample(example);

        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(),prizes);
    }

    /**
     * 上传成绩
     * @param score
     * @param request
     * @return
     */
    @Override
    public ResultVO addScore(Score score, ServletRequest request) {

        //从header中获取token
        HttpServletRequest req= (HttpServletRequest) request;
        String token = req.getHeader("Authorization");

        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        score.setActivistId(id);

        //获取班级人数
        Integer classSize = Integer.valueOf(score.getClassSize());
        //智育排名
        Integer moralRanking= Integer.valueOf(score.getMoralRanking());
        //综测排名
        Integer comprehensiveRanking= Integer.valueOf(score.getComprehensiveRanking());

        //班级人数的一半
        int classHalf = classSize / 2;
        //判断智育排名和综测排名是否为班级前二分之一
        if (moralRanking / 2 <= classHalf && comprehensiveRanking / 2 <= classHalf){
            score.setIsFirsthalf(YES);
        }else {
            score.setIsFirsthalf(NO);
        }

        int i = scoreMapper.insert(score);

        if(i == 1){
            //成功
            return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(),null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(),null);

    }
}
