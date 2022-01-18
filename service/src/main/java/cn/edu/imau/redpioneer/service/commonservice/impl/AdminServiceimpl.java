package cn.edu.imau.redpioneer.service.commonservice.impl;

import cn.edu.imau.redpioneer.dao.PartyBranchMapper;
import cn.edu.imau.redpioneer.entity.PartyBranch;
import cn.edu.imau.redpioneer.dto.PartyBranchDto;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.service.commonservice.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: zyl
 * @date 2021/12/8 22:12
 */
@Service
public class AdminServiceimpl implements AdminService {

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

    /**
     * 更新支部信息
     * @param partyBranch
     * @param request
     * @return
     */
    @Override
    public ResultVO updatePartyBranch(PartyBranch partyBranch, HttpServletRequest request) {
        //从header中获取token
        String token = request.getHeader("Authorization");

        //根据主键更新不为null的值
        int i = partyBranchMapper.updateByPrimaryKeySelective(partyBranch);

        if(i == 1){
            //更新成功
            return new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }

    /**
     * 查询所有支部
     * @return
     */
    @Override
    public ResultVO getAllPartyBranch() {

        List<PartyBranchDto> partyBranches = partyBranchMapper.selectAllPartyBranch();

        partyBranchMapper.selectAllPartyBranch();

        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), partyBranches);
    }

    @Override
    public ResultVO deletePartyBranchById(Integer id) {
        int i = partyBranchMapper.deleteByPrimaryKey(id);
        if(i == 1){
            return new ResultVO(ResStatus.DELETE_OK.getValue(), ResStatus.DELETE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }


}
