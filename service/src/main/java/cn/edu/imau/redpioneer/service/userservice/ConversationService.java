package cn.edu.imau.redpioneer.service.userservice;

import cn.edu.imau.redpioneer.entity.Conversation;
import cn.edu.imau.redpioneer.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * @author: zyl
 * @date 2022/1/1 22:23
 */
public interface ConversationService {
    ResultVO addconversation(Date volunteerTime, String volunteerAddress, String volunteerInfo,String volunteerSize, MultipartFile prove, ServletRequest request) throws IOException;

    ResultVO getConversation(String info);

    ResultVO getConversationById(Integer id);

    ResultVO deleteConversation(Integer id);
}
