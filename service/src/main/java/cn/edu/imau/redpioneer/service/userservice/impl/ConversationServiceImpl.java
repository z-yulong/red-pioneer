package cn.edu.imau.redpioneer.service.userservice.impl;

import cn.edu.imau.redpioneer.dao.ConversationMapper;
import cn.edu.imau.redpioneer.dto.ActivistConversationDto;
import cn.edu.imau.redpioneer.entity.Conversation;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.service.userservice.ConversationService;
import cn.edu.imau.redpioneer.utils.FileUtil;
import cn.edu.imau.redpioneer.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author: zyl
 * @date 2022/1/1 22:24
 */
@Service
public class ConversationServiceImpl implements ConversationService {
    @Autowired
    ConversationMapper conversationMapper;
    @Autowired
    FileUtil fileUtil;

    /**
     * 添加志愿信息
     * @param conversation
     * @param prove
     * @param request
     * @return
     * @throws IOException
     */
    @Override
    public ResultVO addconversation(Conversation conversation, MultipartFile prove, ServletRequest request) throws IOException {

        //从header中获取token
        HttpServletRequest req= (HttpServletRequest) request;
        String token = req.getHeader("Authorization");
        //获取文件保存路径
        String provePATH = fileUtil.uploadImg(prove);

        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        conversation.setActivistId(id);
        conversation.setProve(provePATH);

        conversationMapper.insertSelective(conversation);

        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), null);
    }


    /**
     * 通过姓名或账号查询用户志愿信息
     * @param info
     * @return
     */
    @Override
    public ResultVO getConversation(String info) {

        List<ActivistConversationDto> conversations1 = conversationMapper.selectConversationByAccount(info);

        if(conversations1.size() == 0){
            List<ActivistConversationDto> conversations = conversationMapper.selectConversationByName(info);
            return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), conversations);
        }
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), conversations1);

    }
}
