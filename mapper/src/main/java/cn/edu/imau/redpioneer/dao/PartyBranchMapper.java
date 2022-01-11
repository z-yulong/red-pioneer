package cn.edu.imau.redpioneer.dao;

import cn.edu.imau.redpioneer.entity.PartyBranch;
import cn.edu.imau.redpioneer.entity.PartyBranchInfo;
import cn.edu.imau.redpioneer.general.GeneralDAO;


import java.util.List;

public interface PartyBranchMapper extends GeneralDAO<PartyBranch> {
    List<PartyBranchInfo> selectAllPartyBranch();
}
