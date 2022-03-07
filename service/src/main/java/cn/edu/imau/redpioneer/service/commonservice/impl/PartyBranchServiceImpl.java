package cn.edu.imau.redpioneer.service.commonservice.impl;

import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.dao.PartyBranchMapper;
import cn.edu.imau.redpioneer.dao.PartyGroupMapper;
import cn.edu.imau.redpioneer.dto.PartyGroupDto;
import cn.edu.imau.redpioneer.entity.PartyBranch;
import cn.edu.imau.redpioneer.entity.PartyGroup;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.service.commonservice.PartyBranchService;
import cn.edu.imau.redpioneer.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: zyl
 * @date 2022/1/4 17:29
 */
@Service
public class PartyBranchServiceImpl implements PartyBranchService {

    private PartyGroupMapper partyGroupMapper;
    private PartyBranchMapper partyBranchMapper;
    @Autowired
    public PartyBranchServiceImpl(PartyGroupMapper partyGroupMapper,PartyBranchMapper partyBranchMapper){
        this.partyGroupMapper=partyGroupMapper;
        this.partyBranchMapper=partyBranchMapper;
    }

    private final String AUTHORIZATION ="Authorization";
    /**
     * 新增党小组
     * @param partyGroup
     * @return
     */
    @Override
    public ResultVO addPartyGroup(PartyGroup partyGroup, HttpServletRequest request) {

        //从header中获取token
        String token = request.getHeader(AUTHORIZATION);
        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        //查询当前用户所管理的支部信息
        Example example = new Example(PartyBranch.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activistId",id);
        PartyBranch partyBranch = partyBranchMapper.selectOneByExample(example);

        //设置党小组所在支部
        partyGroup.setBranch(partyBranch.getId());
        //插入
        int i = partyGroupMapper.insert(partyGroup);

        if(i == 1){
            return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);

    }

    /**
     * 根据id删除党小组
     * @param id
     * @return
     */
    @Override
    public ResultVO deletePartyGroupById(Integer id) {

        int i = partyGroupMapper.deleteByPrimaryKey(id);
        if(i == 1){
            return new ResultVO(ResStatus.DELETE_OK.getValue(), ResStatus.DELETE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);

    }

    /**
     * 通过id更新党小组信息
     * @param partyGroup
     * @return
     */
    @Override
    public ResultVO updatePartyGroupById(PartyGroup partyGroup) {

        int i = partyGroupMapper.updateByPrimaryKeySelective(partyGroup);

        if(i == 1){
            //更新成功
            return new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }

    /**
     * 获取自己支部下所有党小组
     * @param request
     * @return
     */
    @Override
    public ResultVO getAllPartyGroup(HttpServletRequest request) {
        //从header中获取token
        String token = request.getHeader("Authorization");
        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        //查询当前用户所管理的支部信息
        Example example = new Example(PartyBranch.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activistId",id);
        PartyBranch partyBranch = partyBranchMapper.selectOneByExample(example);
/**
        //查询自己支部下的党小组
        Example example1 = new Example(PartyGroup.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo("branch",partyBranch.getId());
        List<PartyGroup> partyGroups = partyGroupMapper.selectByExample(example1);
*/
        List<PartyGroupDto> partyGroupDtos = partyGroupMapper.selectMyGroups(partyBranch.getId());
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), partyGroupDtos);


    }

    /**
     * 获取待审批的用户(审批是否可以推重点对象)
     * @return
     */
    @Override
    public ResultVO getAllPending(HttpServletRequest request) {


        return null;
    }
}
