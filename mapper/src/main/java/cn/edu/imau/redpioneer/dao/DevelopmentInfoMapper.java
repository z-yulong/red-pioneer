package cn.edu.imau.redpioneer.dao;

import cn.edu.imau.redpioneer.dto.ActivistDevelopmentDto;
import cn.edu.imau.redpioneer.entity.DevelopmentInfo;
import cn.edu.imau.redpioneer.general.GeneralDAO;

public interface DevelopmentInfoMapper extends GeneralDAO<DevelopmentInfo> {

    ActivistDevelopmentDto selectDevelopmentInfoByName(String name);

    ActivistDevelopmentDto selectDevelopmentInfoByAccount(String account);
}