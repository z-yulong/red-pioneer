package cn.edu.imau.redpioneer.service.commonservice;

import cn.edu.imau.redpioneer.entity.PartyBranch;
import cn.edu.imau.redpioneer.entity.PartyGroup;
import cn.edu.imau.redpioneer.enums.ResultVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zyl
 * @date 2022/1/4 17:29
 */
public interface PartyBranchService {


    ResultVO addPartyGroup(PartyGroup partyGroup, HttpServletRequest request);

    ResultVO deletePartyGroupById(Integer id);

    ResultVO updatePartyGroupById(PartyGroup partyGroup);

    ResultVO getAllPartyGroup(HttpServletRequest request);

    ResultVO getAllPending(HttpServletRequest request);
}
