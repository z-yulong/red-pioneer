package cn.edu.imau.redpioneer.service.commonservice.impl;

import cn.edu.imau.redpioneer.dao.*;
import cn.edu.imau.redpioneer.entity.*;
import cn.edu.imau.redpioneer.enums.State;
import cn.edu.imau.redpioneer.service.commonservice.FaliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zyl
 * @date 2022/3/8 22:25
 */
@Service
public class FaliServiceImpl  implements FaliService{
    private DevelopmentInfoMapper developmentInfoMapper;
    private ScoreMapper scoreMapper;
    private TalkMapper talkMapper;
    private PrizeMapper prizeMapper;
    private ConversationMapper conversationMapper;
    private ActivistMapper activistMapper;

    @Autowired
    public FaliServiceImpl(DevelopmentInfoMapper developmentInfoMapper, ScoreMapper scoreMapper, TalkMapper talkMapper, PrizeMapper prizeMapper, ConversationMapper conversationMapper, ActivistMapper activistMapper) {
        this.developmentInfoMapper = developmentInfoMapper;
        this.scoreMapper = scoreMapper;
        this.talkMapper = talkMapper;
        this.prizeMapper = prizeMapper;
        this.conversationMapper = conversationMapper;
        this.activistMapper = activistMapper;
    }

    /**
     * 发展信息审批未通过
     * @param id development表主键
     * @param remark 备注
     * @return int
     */
    @Override
    public int developmentFail(Integer id, String remark) {
        DevelopmentInfo developmentInfo = new DevelopmentInfo();
        developmentInfo.setId(id);
        //未通过
        developmentInfo.setStateCode(State.FAIL.getValue());

        //如果备注不为null或者""
        if (!remark.isEmpty() || "".equals(remark)){
            developmentInfo.setRemark(remark);
        }
        //根据主键更新不为null的字段
        return developmentInfoMapper.updateByPrimaryKeySelective(developmentInfo);

    }

    /**
     * 奖惩信息
     * @param id prize表主键
     * @return int
     */
    @Override
    public int prizeFail(Integer id) {
        Prize prize=new Prize();
        prize.setId(id);
        //未通过
        prize.setStateCode(State.FAIL.getValue());

        return prizeMapper.updateByPrimaryKeySelective(prize);
    }

    /**
     * 志愿信息
     * @param id conversation表主键
     * @return int
     */
    @Override
    public int conversationFail(Integer id) {
        Conversation conversation = new Conversation();
        conversation.setId(id);
        //未通过
        conversation.setStateCode(State.FAIL.getValue());
        return conversationMapper.updateByPrimaryKeySelective(conversation);
    }

    /**
     *
     * @param id talk表主键
     * @return int
     */
    @Override
    public int talkFail(Integer id) {
        Talk talk = new Talk();

        talk.setId(id);
        //未通过
        talk.setTalkState(State.FAIL.getValue());
        return talkMapper.updateByPrimaryKeySelective(talk);
    }

    /**
     *
     * @param id score表主键
     * @return int
     */
    @Override
    public int scoreFail(Integer id) {
        Score score = new Score();
        score.setId(id);
        //未通过
        score.setStateCode(State.FAIL.getValue());

        return scoreMapper.updateByPrimaryKeySelective(score);
    }


}
