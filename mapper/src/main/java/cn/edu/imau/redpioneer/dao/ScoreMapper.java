package cn.edu.imau.redpioneer.dao;


import cn.edu.imau.redpioneer.dto.ScoreDto;
import cn.edu.imau.redpioneer.entity.Score;
import cn.edu.imau.redpioneer.general.GeneralDAO;

import java.util.List;

public interface ScoreMapper extends GeneralDAO<Score> {
    Integer selectScoreNum(Integer id);
    List<ScoreDto> selectNewScore(Integer id);
    List<ScoreDto> selectScoreByState(Integer state,Integer id);

}