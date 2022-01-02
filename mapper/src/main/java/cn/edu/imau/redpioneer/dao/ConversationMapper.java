package cn.edu.imau.redpioneer.dao;

import cn.edu.imau.redpioneer.entity.ActivistConversation;
import cn.edu.imau.redpioneer.entity.ActivistDevelopmentInfo;
import cn.edu.imau.redpioneer.entity.Conversation;
import cn.edu.imau.redpioneer.general.GeneralDAO;

import java.util.List;

public interface ConversationMapper extends GeneralDAO<Conversation> {


    List<ActivistConversation> selectConversationByName(String name);

    List<ActivistConversation> selectConversationByAccount(String account);
}