package cn.edu.imau.redpioneer.service.commonservice.impl;

import cn.edu.imau.redpioneer.dao.*;
import cn.edu.imau.redpioneer.dto.*;
import cn.edu.imau.redpioneer.enums.State;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.utils.JWTUtil;
import cn.edu.imau.redpioneer.service.commonservice.ApproveService;
import cn.edu.imau.redpioneer.service.commonservice.AuditService;
import cn.edu.imau.redpioneer.service.commonservice.FaliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.NoArgsConstructor;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: zyl
 * @date 2022/3/8 10:22
 */
@Service
@NoArgsConstructor
public class AuditServiceImpl implements AuditService {

    private TrainMapper trainMapper;
    private PartyGroupMapper partyGroupMapper;
    private ActivistMapper activistMapper;
    private DevelopmentInfoMapper developmentInfoMapper;
    private ScoreMapper scoreMapper;
    private TalkMapper talkMapper;
    private PrizeMapper prizeMapper;
    private ConversationMapper conversationMapper;
    private ApproveService approveService;
    private FaliService faliService;

    @Autowired
    public AuditServiceImpl(TrainMapper trainMapper, PartyGroupMapper partyGroupMapper, ActivistMapper activistMapper, DevelopmentInfoMapper developmentInfoMapper, ScoreMapper scoreMapper, TalkMapper talkMapper, PrizeMapper prizeMapper, ConversationMapper conversationMapper, ApproveService approveService, FaliService faliService) {
        this.trainMapper = trainMapper;
        this.partyGroupMapper = partyGroupMapper;
        this.activistMapper = activistMapper;
        this.developmentInfoMapper = developmentInfoMapper;
        this.scoreMapper = scoreMapper;
        this.talkMapper = talkMapper;
        this.prizeMapper = prizeMapper;
        this.conversationMapper = conversationMapper;
        this.approveService = approveService;
        this.faliService = faliService;
    }

    private static final String PRIZE = "prize";
    private static final String DEVELOPMENT = "development";
    private static final String CONVERSATION = "conversation";
    private static final String TALK = "talk";
    private static final String SCORE = "score";

    private static final String TYPE = "Approved-Type";
    private static final String TOKEN = "Authorization";

    /**
     * 获取本党小组待审批用户
     */
    @Override
    public ResultVO getPending(HttpServletRequest request) {
        String type = request.getHeader(TYPE);
        //从header中获取token
        String token = request.getHeader(TOKEN);
        if(token==null){
            return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
        }
        //从token中获取当前用户id
        Integer id = Integer.valueOf(JWTUtil.getIdByToken(token));

        switch (type) {
            case PRIZE: //获取待审批的奖惩信息

                List<ActivistPrizeDto> prizes = prizeMapper.selectPrizeByState(State.PENDING.getValue(),id);
                if (prizes.isEmpty()) {
                    //没有待审批用户
                    return new ResultVO(ResStatus.EMPTY.getValue(), ResStatus.EMPTY.getText(), null);
                }
                return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), prizes);

            case DEVELOPMENT: //获取待审批的发展信息
                List<ActivistDevelopmentDto> developmentInfos = developmentInfoMapper.selectDevelopmentInfoByStateCode(State.PENDING.getValue(),id);
                if (developmentInfos.isEmpty()) {
                    //没有待审批用户
                    return new ResultVO(ResStatus.EMPTY.getValue(), ResStatus.EMPTY.getText(), null);
                }
                return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), developmentInfos);

            case CONVERSATION: //获取待审批的志愿信息
                List<ActivistConversationDto> conversations = conversationMapper.selectConversationByState(State.PENDING.getValue(),id);
                if (conversations.isEmpty()) {
                    //没有待审批用户
                    return new ResultVO(ResStatus.EMPTY.getValue(), ResStatus.EMPTY.getText(), null);
                }
                return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), conversations);

            case TALK: //获取待审批的谈话
                List<TalkDto> talks = talkMapper.selectTalkByState(State.PENDING.getValue(),id);
                if (talks.isEmpty()) {
                    //没有待审批用户
                    return new ResultVO(ResStatus.EMPTY.getValue(), ResStatus.EMPTY.getText(), null);
                }
                return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), talks);
            case SCORE: //获取待审批的成绩
                List<ScoreDto> scoreDtos = scoreMapper.selectScoreByState(State.PENDING.getValue(),id);
                if (scoreDtos.isEmpty()) {
                    //没有待审批用户
                    return new ResultVO(ResStatus.EMPTY.getValue(), ResStatus.EMPTY.getText(), null);
                }
                return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), scoreDtos);
            default: //参数错误
                return new ResultVO(ResStatus.PARAMETER_ERROR.getValue(), ResStatus.PARAMETER_ERROR.getText(), null);
        }

    }

    /**
     * 审批通过
     */
    @Override
    public ResultVO approved(Integer id, String remark, HttpServletRequest request) {
        String type = request.getHeader(TYPE);

        switch (type) {
            case PRIZE:
                return approveService.prizeApproved(id) == 1 ? new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null):
                        new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
            case DEVELOPMENT:
                return approveService.developmentApproved(id, remark) == 1 ? new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null):
                        new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
            case CONVERSATION:
                return approveService.conversationApproved(id) == 1 ? new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null):
                        new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
            case TALK:
                return approveService.talkApproved(id) == 1 ? new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null):
                        new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
            case SCORE:
                return approveService.scoreApproved(id) == 1 ? new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null):
                        new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
            default:
                return new ResultVO(ResStatus.PARAMETER_ERROR.getValue(), ResStatus.PARAMETER_ERROR.getText(), null);
        }

    }


    /**
     * 审批未通过
     */
    @Override
    public ResultVO fail(Integer id, String remark, HttpServletRequest request){
        String type = request.getHeader(TYPE);
        switch (type) {
            case PRIZE:
                return faliService.prizeFail(id) == 1 ? new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null)
                        : new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
            case DEVELOPMENT:
                return faliService.developmentFail(id, remark) == 1 ? new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null)
                        : new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
            case CONVERSATION:
                return faliService.conversationFail(id) == 1 ? new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null)
                        : new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
            case TALK:
                return faliService.talkFail(id) == 1 ? new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null)
                        : new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
            case SCORE:
                return faliService.scoreFail(id) == 1 ? new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null)
                        : new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
            default:
                return new ResultVO(ResStatus.PARAMETER_ERROR.getValue(), ResStatus.PARAMETER_ERROR.getText(), null);
        }


    }





}
