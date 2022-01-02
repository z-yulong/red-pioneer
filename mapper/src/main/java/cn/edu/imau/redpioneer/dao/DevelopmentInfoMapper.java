package cn.edu.imau.redpioneer.dao;


import cn.edu.imau.redpioneer.entity.ActivistDevelopmentInfo;
import cn.edu.imau.redpioneer.entity.DevelopmentInfo;
import cn.edu.imau.redpioneer.general.GeneralDAO;

public interface DevelopmentInfoMapper extends GeneralDAO<DevelopmentInfo> {

    ActivistDevelopmentInfo selectDevelopmentInfoByName(String name);

    ActivistDevelopmentInfo selectDevelopmentInfoByAccount(String account);
}