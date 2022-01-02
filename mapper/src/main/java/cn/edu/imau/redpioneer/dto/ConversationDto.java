package cn.edu.imau.redpioneer.dto;

import cn.edu.imau.redpioneer.entity.ActivistConversation;
import cn.edu.imau.redpioneer.entity.Conversation;

import java.util.List;

/**
 * @author: zyl
 * @date 2022/1/2 12:00
 */
public class ConversationDto extends Conversation {
    private List<ActivistConversation> activistConversations;
}
