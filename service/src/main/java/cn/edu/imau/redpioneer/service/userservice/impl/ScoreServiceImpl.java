package cn.edu.imau.redpioneer.service.userservice.impl;

import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.dao.PrizeMapper;
import cn.edu.imau.redpioneer.dao.ScoreMapper;
import cn.edu.imau.redpioneer.entity.Prize;
import cn.edu.imau.redpioneer.entity.Score;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.service.userservice.ScoreService;
import cn.edu.imau.redpioneer.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: zyl
 * @date 2021/12/11 12:44
 */
@Service
public class ScoreServiceImpl implements ScoreService {
    private static final  Integer YES = 1;
    private static final  Integer NO = 0;

    private ActivistMapper activistMapper;
    private ScoreMapper scoreMapper;
    private PrizeMapper prizeMapper;
    @Autowired
    public ScoreServiceImpl(ActivistMapper activistMapper, PrizeMapper prizeMapper, ScoreMapper scoreMapper) {
        this.activistMapper = activistMapper;
        this.prizeMapper = prizeMapper;
        this.scoreMapper = scoreMapper;
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
        score.setStateCode(1);

        int i = scoreMapper.insert(score);

        if(i == 1){
            //成功
            return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(),null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(),null);

    }

    @Override
    public ResultVO getScoreById(Integer id) {
        Example example=new Example(Score.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activistId",id);
        List<Score> scores = scoreMapper.selectByExample(example);
        return new ResultVO(ResStatus.OK.getValue(),ResStatus.OK.getText(), scores);
    }

    /**
     * 删除用户学习成绩信息
     * @param id
     * @return
     */
    @Override
    public ResultVO deleteScore(Integer id) {
        int i = scoreMapper.deleteByPrimaryKey(id);

        if (i == 1){
            return new ResultVO(ResStatus.DELETE_OK.getValue(), ResStatus.DELETE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }
}
