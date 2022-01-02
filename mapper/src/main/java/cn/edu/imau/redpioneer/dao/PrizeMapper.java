package cn.edu.imau.redpioneer.dao;


import cn.edu.imau.redpioneer.entity.ActivistPrizeInfo;
import cn.edu.imau.redpioneer.entity.Prize;
import cn.edu.imau.redpioneer.general.GeneralDAO;

import java.util.List;

public interface PrizeMapper extends GeneralDAO<Prize> {
    List<ActivistPrizeInfo> selectActivistPrize(Integer id);
}