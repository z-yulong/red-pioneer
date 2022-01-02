package cn.edu.imau.redpioneer.service.commonservice.impl;

import cn.edu.imau.redpioneer.dao.PartyBranchMapper;
import cn.edu.imau.redpioneer.entity.PartyBranch;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.service.commonservice.PartyBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zyl
 * @date 2021/12/8 22:12
 */
@Service
public class PartyBranchServiceimpl implements PartyBranchService {

    @Autowired
    PartyBranchMapper partyBranchMapper;

    /**
     * 新建党支部
     * @param partyBranch
     * @return
     */
    @Override
    public ResultVO addPartyBranch(PartyBranch partyBranch) {

        int i = partyBranchMapper.insert(partyBranch);

        if(i == 1){
            return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }
}
