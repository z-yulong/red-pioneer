package cn.edu.imau.redpioneer.service.userservice;

import cn.edu.imau.redpioneer.entity.Score;
import cn.edu.imau.redpioneer.vo.ResultVO;

import javax.servlet.ServletRequest;

public interface ScoreService {

    ResultVO addScore(Score score, ServletRequest request);

    ResultVO getScoreById(Integer id);

    ResultVO deleteScore(Integer id);

}
