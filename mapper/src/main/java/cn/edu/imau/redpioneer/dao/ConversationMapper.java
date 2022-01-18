package cn.edu.imau.redpioneer.dao;

import cn.edu.imau.redpioneer.dto.ActivistConversationDto;
import cn.edu.imau.redpioneer.entity.Conversation;
import cn.edu.imau.redpioneer.general.GeneralDAO;

import java.util.List;

public interface ConversationMapper extends GeneralDAO<Conversation> {


    List<ActivistConversationDto> selectConversationByName(String name);

    List<ActivistConversationDto> selectConversationByAccount(String account);
}