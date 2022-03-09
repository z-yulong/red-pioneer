package cn.edu.imau.redpioneer.service.commonservice;

import cn.edu.imau.redpioneer.entity.PartyBranch;
import cn.edu.imau.redpioneer.vo.ResultVO;

import javax.servlet.http.HttpServletRequest;

public interface AdminService {

    ResultVO addPartyBranch(PartyBranch partyBranch);

    ResultVO updatePartyBranch(PartyBranch partyBranch, HttpServletRequest request);

    ResultVO getAllPartyBranch();

    ResultVO deletePartyBranchById(Integer id);
}
