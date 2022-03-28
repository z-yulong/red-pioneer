package cn.edu.imau.redpioneer.service.userservice.impl;

import cn.edu.imau.redpioneer.dao.ConversationMapper;
import cn.edu.imau.redpioneer.dto.ActivistConversationDto;
import cn.edu.imau.redpioneer.entity.Conversation;
import cn.edu.imau.redpioneer.entity.DevelopmentInfo;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.service.userservice.ConversationService;
import cn.edu.imau.redpioneer.utils.FileUtil;
import cn.edu.imau.redpioneer.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author: zyl
 * @date 2022/1/1 22:24
 */
@Service
public class ConversationServiceImpl implements ConversationService {

    private ConversationMapper conversationMapper;
    private FileUtil fileUtil;
    @Autowired
    public ConversationServiceImpl(ConversationMapper conversationMapper, FileUtil fileUtil) {
        this.conversationMapper = conversationMapper;
        this.fileUtil = fileUtil;
    }

    /**
     * 添加志愿信息
     * @param prove
     * @param request
     * @return
     * @throws IOException
     */
    @Override
    public ResultVO addconversation(Date volunteerTime, String volunteerAddress, String volunteerInfo, String volunteerSize, MultipartFile prove, ServletRequest request) throws IOException {

        //从header中获取token
        HttpServletRequest req= (HttpServletRequest) request;
        String token = req.getHeader("Authorization");
        //获取文件保存路径
        String provePATH = fileUtil.uploadImg(prove);

        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        Conversation conversation = new Conversation();

        conversation.setActivistId(id);
        conversation.setVolunteerTime(volunteerTime);
        conversation.setVolunteerAddress(volunteerAddress);
        conversation.setVolunteerInfo(volunteerInfo);
        conversation.setVolunteerSize(volunteerSize);
        conversation.setProve(provePATH);

        int i = conversationMapper.insertSelective(conversation);

        if(i == 1){
            //成功
            return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(),null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(),null);
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

    /**
     * 通过id查询所有志愿信息
     * @param id
     * @return
     */
    @Override
    public ResultVO getConversationById(Integer id) {
        Example example=new Example(Conversation.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activistId",id);
        List<Conversation> conversations = conversationMapper.selectByExample(example);
        return new ResultVO(ResStatus.OK.getValue(),ResStatus.OK.getText(), conversations);
    }

    /**
     * 删除用户志愿信息
     * @param id
     * @return
     */
    @Override
    public ResultVO deleteConversation(Integer id) {
        int i = conversationMapper.deleteByPrimaryKey(id);

        if (i == 1){
            return new ResultVO(ResStatus.DELETE_OK.getValue(), ResStatus.DELETE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }
}
