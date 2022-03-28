package cn.edu.imau.redpioneer.service.commonservice.impl;

import cn.edu.imau.redpioneer.dao.*;
import cn.edu.imau.redpioneer.entity.*;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.enums.State;
import cn.edu.imau.redpioneer.service.commonservice.ApproveService;
import cn.edu.imau.redpioneer.utils.MessageUtil;
import cn.edu.imau.redpioneer.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author: zyl
 * @date 2022/3/8 18:13
 */
@Service
public class ApproveServiceImpl implements ApproveService {

    private DevelopmentInfoMapper developmentInfoMapper;
    private ScoreMapper scoreMapper;
    private TalkMapper talkMapper;
    private PrizeMapper prizeMapper;
    private ConversationMapper conversationMapper;
    private ActivistMapper activistMapper;

    @Autowired
    public ApproveServiceImpl(DevelopmentInfoMapper developmentInfoMapper, ScoreMapper scoreMapper, TalkMapper talkMapper, PrizeMapper prizeMapper, ConversationMapper conversationMapper, ActivistMapper activistMapper) {
        this.developmentInfoMapper = developmentInfoMapper;
        this.scoreMapper = scoreMapper;
        this.talkMapper = talkMapper;
        this.prizeMapper = prizeMapper;
        this.conversationMapper = conversationMapper;
        this.activistMapper = activistMapper;
    }

    /**
     * 发展信息审批通过
     */

    public int developmentApproved(Integer id,String remark) {
        DevelopmentInfo developmentInfo = new DevelopmentInfo();
        developmentInfo.setId(id);
        //通过
        developmentInfo.setStateCode(State.APPROVED.getValue());

        //如果 备注 不为null或者""
        if (!remark.isEmpty() || "".equals(remark)){
            developmentInfo.setRemark(remark);
        }
        //根据主键更新不为null的字段
        int i = developmentInfoMapper.updateByPrimaryKeySelective(developmentInfo);

        if(i == 1){
            //更新成功
            //创建一个Example封装类 类别DevelopmentInfo查询条件
            Example example = new Example(DevelopmentInfo.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id", id);
            //查询本次审批的记录
            DevelopmentInfo development = developmentInfoMapper.selectOneByExample(example);

            //这个操作的目的是为了拿到审批通过的发展信息的用户邮箱
            Example activistExample = new Example(Activist.class);
            Example.Criteria activistCriteria = activistExample.createCriteria();
            Integer activistId = development.getActivistId();
            activistCriteria.andEqualTo("id", activistId);
            //通过本次审批记录中的activistId查询这条记录的用户
            Activist activist = activistMapper.selectOneByExample(activistExample);

            //发送邮件
            MessageUtil messageUtil = new MessageUtil();
            messageUtil.sendMessage(activist.getEmail(),"谈话通知","您的发展信息已审核通过，请于15日内上传您的第一次谈话记录！");

            return i;
        }
        return i;
    }

    /**
     * 奖惩信息
     * @param id id
     * @return int
     */
    @Override
    public int prizeApproved(Integer id) {

        Prize prize = new Prize();
        prize.setId(id);
        //通过
        prize.setStateCode(State.APPROVED.getValue());

        //根据主键更新不为null的字段

        return prizeMapper.updateByPrimaryKeySelective(prize);
    }

    /**
     * 志愿信息
     * @param id id
     * @return int
     */
    @Override
    public int conversationApproved(Integer id) {
        Conversation conversation = new Conversation();
        conversation.setId(id);
        //通过
        conversation.setStateCode(State.APPROVED.getValue());
        //根据主键更新不为null的字段
        return conversationMapper.updateByPrimaryKeySelective(conversation);

    }

    /**
     * 谈话
     * @param id id
     * @return int
     */
    @Override
    public int talkApproved(Integer id) {
        Talk talk = new Talk();
        talk.setId(id);
        //通过
        talk.setTalkState(State.APPROVED.getValue());
        //根据主键更新不为null的字段
        return talkMapper.updateByPrimaryKeySelective(talk);
    }

    /**
     * 成绩
     * @param id id
     * @return int
     */
    @Override
    public int scoreApproved(Integer id) {
        Score score = new Score();
        score.setId(id);
        //通过
        score.setStateCode(State.APPROVED.getValue());
        //根据主键更新不为null的字段
        return scoreMapper.updateByPrimaryKeySelective(score);
    }





}
