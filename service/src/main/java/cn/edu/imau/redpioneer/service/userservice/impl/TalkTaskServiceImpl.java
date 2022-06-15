package cn.edu.imau.redpioneer.service.userservice.impl;

import cn.edu.imau.redpioneer.dao.*;
import cn.edu.imau.redpioneer.dto.ScoreDto;
import cn.edu.imau.redpioneer.dto.TalkNumDto;
import cn.edu.imau.redpioneer.dto.TotalDto;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.enums.TalkState;
import cn.edu.imau.redpioneer.service.userservice.TalkTaskService;
import cn.edu.imau.redpioneer.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: zyl
 * @date 2022/1/18 9:58
 */
@Service
@Component
public class TalkTaskServiceImpl implements TalkTaskService {

    private MessageUtil messageUtil;
    private ScoreMapper scoreMapper;
    private PrizeMapper prizeMapper;
    private ConversationMapper conversationMapper;
    private TalkMapper talkMapper;
    private ActivistMapper activistMapper;
    @Autowired
    public TalkTaskServiceImpl(MessageUtil messageUtil, ScoreMapper scoreMapper, PrizeMapper prizeMapper, ConversationMapper conversationMapper, TalkMapper talkMapper, ActivistMapper activistMapper) {
        this.messageUtil = messageUtil;
        this.scoreMapper = scoreMapper;
        this.prizeMapper = prizeMapper;
        this.conversationMapper = conversationMapper;
        this.talkMapper = talkMapper;
        this.activistMapper = activistMapper;
    }

    //private static final String EXECUTION_TIME ="0 50 17 * * ?";
    private static final String EXECUTION_TIME ="0 0 2 * * ?";
    private static final Integer TOTAL =150;
    private static final Integer GROUP_TALK_NUM =4;
    private static final Integer PARTY_TALK_NUM =2;



    @Scheduled(cron = EXECUTION_TIME)
    @Override
    public ResultVO recommend() {
        ArrayList<Integer> totalYES = new ArrayList<>();
        ArrayList<Integer> talkYES = new ArrayList<>();
        ArrayList<Integer> partyTalkYES = new ArrayList<>();

        //查询所有人志愿总时长
        List<TotalDto> totals = conversationMapper.selectTotal();

        //遍历所有将总时长大于等于150的人下姓名add到totalYES
        for (TotalDto total : totals) {
            if(Integer.valueOf(total.getTotal()) >= TOTAL){
                totalYES.add(total.getId());
            }
        }

        //查询所有人已审批通过小组谈话次数
        List<TalkNumDto> talknums = talkMapper.selectTalkNum(TalkState.GROUP_APPROVED.getValue());
        //遍历所有谈话次数将谈话次数大于等于4次的add
        for (TalkNumDto talknum : talknums) {
            if(talknum.getNum() >= GROUP_TALK_NUM){
                talkYES.add(talknum.getId());
            }
        }

        //查询所有人已审批通过支部谈话次数
        List<TalkNumDto> partyTalknums = talkMapper.selectTalkNum(TalkState.PARTY_APPROVED.getValue());
        //遍历所有谈话次数将谈话次数大于等于4次的add到qualifieds
        for (TalkNumDto partyTalknum : partyTalknums) {
            if(partyTalknum.getNum() >= PARTY_TALK_NUM){
                partyTalkYES.add(partyTalknum.getId());
            }
        }

        //取交集
        talkYES.retainAll(totalYES);
        talkYES.retainAll(partyTalkYES);

        for (Iterator<Integer> it = talkYES.iterator(); it.hasNext();) {

            Integer num = scoreMapper.selectScoreNum(it.next());//查询记录数（通过奇偶判断学年）
            if(num % 2 == 1 || num==0){
                it.remove();
                continue;
            }
            List<ScoreDto> lastYearScore = scoreMapper.selectNewScore(it.next());//查询上一学年成绩信息
            ScoreDto score1 = lastYearScore.get(0);
            ScoreDto score2 = lastYearScore.get(1);

            //如果有一学期成绩未过班级前1/2
            if(score1.getIsFirsthalf()==0 || score2.getIsFirsthalf() == 0 || score1.getStateCode()==1 || score2.getStateCode()==1){
                it.remove();
                continue;
            }
        }

        for (Integer id : talkYES) {
            //将符合所有条件的用户状态改为待审批（ 3 ）
            activistMapper.updateStateCode(TalkState.PENDING.getValue(),id);
             //通过id查询email
             String email = activistMapper.selectEmailByName(id);
             //发送邮件
             messageUtil.sendMessage(email,"内蒙古农业大学","您已完成了积极分子阶段的全部任务！");
        }
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), talkYES);
    }


}
