package cn.edu.imau.redpioneer.dao;



import cn.edu.imau.redpioneer.dto.ActivistPrizeDto;
import cn.edu.imau.redpioneer.entity.Prize;
import cn.edu.imau.redpioneer.general.GeneralDAO;

import java.util.List;

public interface PrizeMapper extends GeneralDAO<Prize> {
    List<ActivistPrizeDto> selectActivistPrize(Integer id);

    List<ActivistPrizeDto> selectPrizeByState(Integer state,Integer id);
}