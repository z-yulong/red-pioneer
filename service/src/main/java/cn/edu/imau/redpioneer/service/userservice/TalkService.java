package cn.edu.imau.redpioneer.service.userservice;

import cn.edu.imau.redpioneer.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.IOException;
import java.util.Date;

public interface TalkService {
    ResultVO uploadTalk(Date talkTime, String talkPeople, Integer talkType, MultipartFile prove, ServletRequest request) throws IOException;

    ResultVO getTalkById(Integer id);

    ResultVO deleteTalkById(Integer id);

}
