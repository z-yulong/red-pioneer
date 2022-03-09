package cn.edu.imau.redpioneer.service.userservice;

import cn.edu.imau.redpioneer.vo.ResultVO;

public interface TalkTaskService {

   //ResultVO partyGroupTalk(Date talkTime, String talkPeople, Integer talkType, MultipartFile proveImg);
    ResultVO partyGroupTalk();

    //ResultVO partyBrabchTalk(Date talkTime, String talkPeople, Integer talkType, MultipartFile proveImg); ResultVO partyGroupTalk(Date talkTime, String talkPeople, Integer talkType, MultipartFile proveImg);

    ResultVO recommend();
}
