package cn.edu.imau.redpioneer.service.commonservice;

import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.entity.Train;
import cn.edu.imau.redpioneer.vo.ResultVO;

import javax.servlet.http.HttpServletRequest;

public interface PartyGroupService {
    ResultVO addTrain(Train train, HttpServletRequest request);

    ResultVO deleteTrainById(Integer id);

    ResultVO updateTrainById(Train train);

    ResultVO getAllTrain(HttpServletRequest request);

    ResultVO updateActivist(Activist activist);


    //ResultVO getRecommend();
}
