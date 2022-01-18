package cn.edu.imau.redpioneer.service.userservice;

import cn.edu.imau.redpioneer.entity.Score;
import cn.edu.imau.redpioneer.entity.Talk;
import cn.edu.imau.redpioneer.enums.ResultVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.util.Date;

public interface TalkTaskService {

   //ResultVO partyGroupTalk(Date talkTime, String talkPeople, Integer talkType, MultipartFile proveImg);
    ResultVO partyGroupTalk();

    //ResultVO partyBrabchTalk(Date talkTime, String talkPeople, Integer talkType, MultipartFile proveImg); ResultVO partyGroupTalk(Date talkTime, String talkPeople, Integer talkType, MultipartFile proveImg);

    ResultVO partyBrabchTalk();
}
