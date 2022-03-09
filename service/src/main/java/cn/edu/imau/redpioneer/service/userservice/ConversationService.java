package cn.edu.imau.redpioneer.service.userservice;

import cn.edu.imau.redpioneer.entity.Conversation;
import cn.edu.imau.redpioneer.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.IOException;

/**
 * @author: zyl
 * @date 2022/1/1 22:23
 */
public interface ConversationService {
    ResultVO addconversation(Conversation conversation, MultipartFile prove, ServletRequest request) throws IOException;

    ResultVO getConversation(String info);
}
