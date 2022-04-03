package cn.edu.imau.redpioneer.dao;

import cn.edu.imau.redpioneer.dto.GradeNumDto;
import cn.edu.imau.redpioneer.dto.PartyBranchDto;
import cn.edu.imau.redpioneer.entity.PartyBranch;

import cn.edu.imau.redpioneer.general.GeneralDAO;

import java.util.List;

public interface PartyBranchMapper extends GeneralDAO<PartyBranch> {
    List<PartyBranchDto> selectAllPartyBranch();

    Integer selectMyBranchId(Integer id);

    List<Integer> selectBranchGroupActivistId(Integer id);


}
