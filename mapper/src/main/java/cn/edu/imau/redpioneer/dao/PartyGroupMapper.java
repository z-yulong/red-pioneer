package cn.edu.imau.redpioneer.dao;


import cn.edu.imau.redpioneer.dto.PartyGroupDto;
import cn.edu.imau.redpioneer.entity.PartyGroup;
import cn.edu.imau.redpioneer.general.GeneralDAO;

import java.util.List;

public interface PartyGroupMapper extends GeneralDAO<PartyGroup> {

    List<PartyGroupDto> selectMyGroups(Integer id);
}