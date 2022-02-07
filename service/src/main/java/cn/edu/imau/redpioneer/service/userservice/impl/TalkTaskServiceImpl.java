package cn.edu.imau.redpioneer.service.userservice.impl;

import cn.edu.imau.redpioneer.dao.*;
import cn.edu.imau.redpioneer.dto.ScoreDto;
import cn.edu.imau.redpioneer.dto.TalkNumDto;
import cn.edu.imau.redpioneer.dto.TotalDto;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.enums.TalkState;
import cn.edu.imau.redpioneer.service.userservice.TalkTaskService;
import cn.edu.imau.redpioneer.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zyl
 * @date 2022/1/18 9:58
 */
@Service
@Component
public class TalkTaskServiceImpl implements TalkTaskService {

    @Autowired
    MessageUtil messageUtil;
    @Autowired
    ScoreMapper scoreMapper;
    @Autowired
    PrizeMapper prizeMapper;
    @Autowired
    ConversationMapper conversationMapper;
    @Autowired
    TalkMapper talkMapper;
    @Autowired
    ActivistMapper activistMapper;

    //private static final String EXECUTION_TIME ="0 52 18 * * ?";
    private static final String EXECUTION_TIME ="0 0 2 * * ?";
    private static final Integer TOTAL =150;
    private static final Integer GROUP_TALK_NUM =4;
    private static final Integer PARTY_TALK_NUM =2;


    @Override
    public ResultVO partyGroupTalk() {

        return null;
    }

    //每天凌晨2点执行
    @Scheduled(cron = EXECUTION_TIME)
    @Override
    public ResultVO recommend() {
        ArrayList<String> totalYES = new ArrayList<>();
        ArrayList<String> talkYES = new ArrayList<>();
        ArrayList<String> partyTalkYES = new ArrayList<>();

        //查询所有人志愿总时长
        List<TotalDto> totals = conversationMapper.selectTotal();

        //遍历所有将总时长大于等于150的add到qualifieds
        for (TotalDto total : totals) {
            if(Integer.valueOf(total.getTotal()) >= TOTAL){
                totalYES.add(total.getName());
            }
        }

        //查询所有人已审批通过小组谈话次数
        List<TalkNumDto> talknums = talkMapper.selectTalkNum(TalkState.GROUP_APPROVED.getValue());
        //遍历所有谈话次数将谈话次数大于等于4次的add到qualifieds
        for (TalkNumDto talknum : talknums) {
            if(talknum.getNum() >= GROUP_TALK_NUM){
                talkYES.add(talknum.getName());
            }
        }

        //查询所有人已审批通过支部谈话次数
        List<TalkNumDto> partyTalknums = talkMapper.selectTalkNum(TalkState.PARTY_APPROVED.getValue());
        //遍历所有谈话次数将谈话次数大于等于4次的add到qualifieds
        for (TalkNumDto partyTalknum : partyTalknums) {
            if(partyTalknum.getNum() >= PARTY_TALK_NUM){
                partyTalkYES.add(partyTalknum.getName());
            }
        }

        //取交集
        talkYES.retainAll(totalYES);
        talkYES.retainAll(partyTalkYES);

        for (String talk : talkYES) {
            //num=1: 记录为双数
            //num=0: 记录为单数
            Integer num = scoreMapper.selectScoreNum(talk);//查询记录数（通过奇偶判断学年）
            List<ScoreDto> lastYearScore = scoreMapper.selectNewScore(talk);//查询上一学年成绩信息

            ScoreDto score1 = lastYearScore.get(0);
            ScoreDto score2 = lastYearScore.get(1);

            //如果记录为单数则移除
            if(num==0 || score1.getIsFirsthalf()==0 || score2.getIsFirsthalf() == 0){
                talkYES.remove(talk);
            }
        }

        for (String name : talkYES) {
            //将符合所有条件的用户状态改为待审批（ 3 ）
            activistMapper.updateStateCode(TalkState.PENDING.getValue(),name);

             //通过name查询email
             String email = activistMapper.selectEmailByName(name);

             //发送邮件
             messageUtil.sendMessage(email,"恭喜"+ name,"您已完成了积极分子阶段的全部任务！");

        }

        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), talkYES);
    }


}
