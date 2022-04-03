package cn.edu.imau.redpioneer.service.commonservice.impl;

import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.dao.PartyBranchMapper;
import cn.edu.imau.redpioneer.dao.PartyGroupMapper;
import cn.edu.imau.redpioneer.dto.GradeNumDto;
import cn.edu.imau.redpioneer.dto.NationNumDto;
import cn.edu.imau.redpioneer.dto.PartyGroupDto;
import cn.edu.imau.redpioneer.dto.SexNumDto;
import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.entity.PartyBranch;
import cn.edu.imau.redpioneer.entity.PartyGroup;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.utils.MessageUtil;
import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.service.commonservice.PartyBranchService;
import cn.edu.imau.redpioneer.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zyl
 * @date 2022/1/4 17:29
 */
@Service
public class PartyBranchServiceImpl implements PartyBranchService {

    private MessageUtil messageUtil;
    private PartyGroupMapper partyGroupMapper;
    private PartyBranchMapper partyBranchMapper;
    private ActivistMapper activistMapper;
    @Autowired
    public PartyBranchServiceImpl(PartyGroupMapper partyGroupMapper,PartyBranchMapper partyBranchMapper,ActivistMapper activistMapper,MessageUtil messageUtil){
        this.partyGroupMapper=partyGroupMapper;
        this.partyBranchMapper=partyBranchMapper;
        this.activistMapper=activistMapper;
        this.messageUtil=messageUtil;
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

        List<PartyGroupDto> partyGroupDtos = partyGroupMapper.selectMyGroups(partyBranch.getId());
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), partyGroupDtos);

    }

    /**
     * 获取待审批的用户(审批是否可以推重点对象)
     * @return
     */
    @Override
    public ResultVO getAllPending(HttpServletRequest request) {
        //从header中获取token
        String token = request.getHeader("Authorization");
        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));
        List<Activist> ok=new ArrayList<>();

        //当前用户管理的支部的id
        Integer myBranchId = partyBranchMapper.selectMyBranchId(id);
        //当前用户支部下的党小组的负责人id
        List<Integer> myBranchGroupActivistId = partyBranchMapper.selectBranchGroupActivistId(myBranchId);

        //查询待审批的用户
        Example example = new Example(Activist.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("stateCode",3);
        List<Activist> activists = activistMapper.selectByExample(example);

        for (Activist activist : activists) {
            for (Integer integer : myBranchGroupActivistId) {
                if (integer.equals(activist.getPartyGroup())){
                    ok.add(activist);

                }
            }
        }
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), ok);
    }
    /**
     * 通过
     * @param id
     * @param remark
     * @param request
     * @return
     */
    @Override
    public ResultVO approved(Integer id, String remark, HttpServletRequest request) {
        Activist activist = new Activist();
        activist.setId(id);
        activist.setStateCode(0);
        int i = activistMapper.updateByPrimaryKeySelective(activist);
        if(i == 1){
            //通过id查询email
            String email = activistMapper.selectEmailByName(id);
            //发送邮件
            messageUtil.sendMessage(email,"内蒙古农业大学"
                    ,"恭喜您已通过重点培养对象审核！");
            //更新成功
            return new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }

    /**
     * 未通过
     * @param id
     * @param remark
     * @param request
     * @return
     */
    @Override
    public ResultVO fail(Integer id, String remark, HttpServletRequest request) {
        Activist activist = new Activist();
        activist.setId(id);
        activist.setStateCode(1);
        int i = activistMapper.updateByPrimaryKeySelective(activist);
        if(i == 1){
            //通过id查询email
            String email = activistMapper.selectEmailByName(id);
            //发送邮件
            messageUtil.sendMessage(email,"内蒙古农业大学"
                    ,"您的重点培养对象审核未通过！"+"\n"+"原因："+remark);
            //更新成功
            return new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }
/*******************************************************************************************************************/
    /**
     * 获取支部人数
     * @return
     */
    @Override
    public ResultVO getBranchNum() {

        List<GradeNumDto> gradeNumDtos = activistMapper.selectBranchActivistNum();
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), gradeNumDtos);
    }

    /**
     * 获取支部各名民族人数
     * @param
     * @return
     */
    @Override
    public ResultVO getBranchNationNum() {
        List<NationNumDto> nationNumDtos = activistMapper.selectBranchNationNum();
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), nationNumDtos);
    }

    /**
     * 获取支部各性别人数
     * @return
     */
    @Override
    public ResultVO getBranchSexNum() {
        List<SexNumDto> sexNumDtos = activistMapper.selectBranchSexNum();
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), sexNumDtos);
    }

    /**
     * 获取支部各年级人数
     * @return
     */
    @Override
    public ResultVO getBranchGradeNum() {
        List<GradeNumDto> gradeNumDtos = activistMapper.selectBranchGradeNum();
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), gradeNumDtos);
    }



}
