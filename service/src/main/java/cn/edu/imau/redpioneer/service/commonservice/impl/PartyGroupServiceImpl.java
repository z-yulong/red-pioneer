package cn.edu.imau.redpioneer.service.commonservice.impl;

import cn.edu.imau.redpioneer.dao.*;
import cn.edu.imau.redpioneer.dto.ActivistNumDto;
import cn.edu.imau.redpioneer.dto.GradeNumDto;
import cn.edu.imau.redpioneer.dto.NationNumDto;
import cn.edu.imau.redpioneer.dto.SexNumDto;
import cn.edu.imau.redpioneer.entity.*;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.service.commonservice.PartyGroupService;
import cn.edu.imau.redpioneer.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: zyl
 * @date 2022/1/6 15:38
 */
@Service
public class PartyGroupServiceImpl implements PartyGroupService {
    private TrainMapper trainMapper;
    private PartyGroupMapper partyGroupMapper;
    private ActivistMapper activistMapper;
    private DevelopmentInfoMapper developmentInfoMapper;
    private ScoreMapper scoreMapper;
    private TalkMapper talkMapper;
    private PrizeMapper prizeMapper;
    private ConversationMapper conversationMapper;
    private PartyBranchMapper partyBranchMapper;
    //构造器
    @Autowired
    public PartyGroupServiceImpl( PartyBranchMapper partyBranchMapper,TrainMapper trainMapper, PartyGroupMapper partyGroupMapper, ActivistMapper activistMapper, DevelopmentInfoMapper developmentInfoMapper, ScoreMapper scoreMapper, TalkMapper talkMapper, PrizeMapper prizeMapper, ConversationMapper conversationMapper) {
        this.trainMapper = trainMapper;
        this.partyGroupMapper = partyGroupMapper;
        this.activistMapper = activistMapper;
        this.developmentInfoMapper = developmentInfoMapper;
        this.scoreMapper = scoreMapper;
        this.talkMapper = talkMapper;
        this.prizeMapper = prizeMapper;
        this.conversationMapper = conversationMapper;
        this.partyBranchMapper = partyBranchMapper;
    }



    /**
     * 添加培养人
     * @param train 培养人
     * @param request request
     * @return ResultVO
     */
    @Override
    public ResultVO addTrain(Train train, HttpServletRequest request) {

        //从header中获取token
        String token = request.getHeader("Authorization");
        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        //查询当前用户所管理的党小组信息
        Example example = new Example(PartyGroup.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activistId",id);
        PartyGroup partyGroup = partyGroupMapper.selectOneByExample(example);

        //设置培养人所属党小组
        train.setPartyGroupId(partyGroup.getId());
        //插入
        int i = trainMapper.insert(train);
        if(i == 1){
            return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);

    }

    /**
     * 通过id删除培养人
     * @param id id
     * @return ResultVO
     */
    @Override
    public ResultVO deleteTrainById(Integer id) {
        int i = trainMapper.deleteByPrimaryKey(id);
        if(i == 1){
            return new ResultVO(ResStatus.DELETE_OK.getValue(), ResStatus.DELETE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }

    /**
     * 通过id更新培养人信息
     * @param train 培养人
     * @return ResultVO
     */
    @Override
    public ResultVO updateTrainById(Train train) {
        int i = trainMapper.updateByPrimaryKeySelective(train);

        if(i == 1){
            //更新成功
            return new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }


    /**
     * 通过id修改积极分子信息，培养人分配
     * @return null
     */
    @Override
    public ResultVO updateActivist(Activist activist) {

        int i = activistMapper.updateByPrimaryKeySelective(activist);

        if(i == 1){
            //更新成功
            return new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }
    /**
     * 获取自己小组下所有培养人
     * @return trains
     */
    @Override
    public ResultVO getAllTrain(HttpServletRequest request) {
        //从header中获取token
        String token = request.getHeader("Authorization");
        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        //查询自己党小组下培养人
        Example example = new Example(Train.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("partyGroupId",id);
        List<Train> trains = trainMapper.selectByExample(example);
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), trains);
    }

    /**
     * 获取自己小组下所有人
     * @return
     */
    @Override
    public ResultVO getAllActivist(HttpServletRequest request) {
        //从header中获取token
        String token = request.getHeader("Authorization");
        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        //查询自己党小组下所有人
        Example example = new Example(Activist.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("partyGroup",id);
        List<Activist> activists = activistMapper.selectByExample(example);

        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), activists);
    }

    @Override
    public ResultVO getAllActivistById(Integer id) {
        int activistId = partyGroupMapper.selectGroupActivistId(id);

        //查询自己党小组下所有人
        Example example = new Example(Activist.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("partyGroup",activistId);
        List<Activist> activists = activistMapper.selectByExample(example);
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), activists);
    }
/****************************************************************************************************************/

/**
     * 获取党小组人数
     * @return
     */
    @Override
    public ResultVO getGroupNum(HttpServletRequest request) {
        //从header中获取token
        String token = request.getHeader("Authorization");
        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        Example example = new Example(PartyBranch.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activistId",id);

        PartyBranch partyBranch = partyBranchMapper.selectOneByExample(example);


        List<ActivistNumDto> gradeNumDtos = activistMapper.selectGroupActivistNum(partyBranch.getId());
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), gradeNumDtos);
    }

    /**
     * 获取党小组各名民族人数
     * @return
     */
    @Override
    public ResultVO getGroupNationNum(HttpServletRequest request) {
        //从header中获取token
        String token = request.getHeader("Authorization");
        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));
        Example example = new Example(PartyBranch.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activistId",id);
        PartyBranch partyBranch = partyBranchMapper.selectOneByExample(example);

        List<NationNumDto> nationNumDtos = activistMapper.selectGroupNationNum(partyBranch.getId());
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), nationNumDtos);
    }

    /**
     * 获取党小组各性别人数
     * @return
     */
    @Override
    public ResultVO getGroupSexNum(HttpServletRequest request) {
        //从header中获取token
        String token = request.getHeader("Authorization");
        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));
        Example example = new Example(PartyBranch.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activistId",id);
        PartyBranch partyBranch = partyBranchMapper.selectOneByExample(example);


        List<SexNumDto> sexNumDtos = activistMapper.selectGroupSexNum(partyBranch.getId());
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), sexNumDtos);
    }

    /**
     * 获取党小组各年级人数
     * @return
     */
    @Override
    public ResultVO getGroupGradeNum(HttpServletRequest request) {
        //从header中获取token
        String token = request.getHeader("Authorization");
        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));
        Example example = new Example(PartyBranch.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activistId",id);
        PartyBranch partyBranch = partyBranchMapper.selectOneByExample(example);


        List<GradeNumDto> gradeNumDtos = activistMapper.selectGroupGradeNum(partyBranch.getId());
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), gradeNumDtos);
    }



}