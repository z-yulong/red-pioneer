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

        //??????????????????????????????
        List<TotalDto> totals = conversationMapper.selectTotal();

        //????????????????????????????????????150???????????????add???totalYES
        for (TotalDto total : totals) {
            if(Integer.valueOf(total.getTotal()) >= TOTAL){
                totalYES.add(total.getId());
            }
        }

        //????????????????????????????????????????????????
        List<TalkNumDto> talknums = talkMapper.selectTalkNum(TalkState.GROUP_APPROVED.getValue());
        //???????????????????????????????????????????????????4??????add
        for (TalkNumDto talknum : talknums) {
            if(talknum.getNum() >= GROUP_TALK_NUM){
                talkYES.add(talknum.getId());
            }
        }

        //????????????????????????????????????????????????
        List<TalkNumDto> partyTalknums = talkMapper.selectTalkNum(TalkState.PARTY_APPROVED.getValue());
        //???????????????????????????????????????????????????4??????add???qualifieds
        for (TalkNumDto partyTalknum : partyTalknums) {
            if(partyTalknum.getNum() >= PARTY_TALK_NUM){
                partyTalkYES.add(partyTalknum.getId());
            }
        }

        //?????????
        talkYES.retainAll(totalYES);
        talkYES.retainAll(partyTalkYES);

        for (Iterator<Integer> it = talkYES.iterator(); it.hasNext();) {

            Integer num = scoreMapper.selectScoreNum(it.next());//?????????????????????????????????????????????
            if(num % 2 == 1 || num==0){
                it.remove();
                continue;
            }
            List<ScoreDto> lastYearScore = scoreMapper.selectNewScore(it.next());//??????????????????????????????
            ScoreDto score1 = lastYearScore.get(0);
            ScoreDto score2 = lastYearScore.get(1);

            //???????????????????????????????????????1/2
            if(score1.getIsFirsthalf()==0 || score2.getIsFirsthalf() == 0 || score1.getStateCode()==1 || score2.getStateCode()==1){
                it.remove();
                continue;
            }
        }

        for (Integer id : talkYES) {
            //?????????????????????????????????????????????????????? 3 ???
            activistMapper.updateStateCode(TalkState.PENDING.getValue(),id);
             //??????id??????email
             String email = activistMapper.selectEmailByName(id);
             //????????????
             messageUtil.sendMessage(email,"?????????????????????","???????????????????????????????????????????????????");
        }
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), talkYES);
    }


}
