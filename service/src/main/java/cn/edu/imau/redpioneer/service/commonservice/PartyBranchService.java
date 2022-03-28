package cn.edu.imau.redpioneer.service.commonservice;

import cn.edu.imau.redpioneer.entity.PartyGroup;
import cn.edu.imau.redpioneer.vo.ResultVO;

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

    ResultVO getBranchNum(Integer id);

    ResultVO getBranchNationNum(Integer id);

    ResultVO getBranchSexNum(Integer id);

    ResultVO getBranchGradeNum(Integer id);

    ResultVO approved(Integer id, String remark, HttpServletRequest request);

    ResultVO fail(Integer id, String remark, HttpServletRequest request);
}
