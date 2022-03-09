package cn.edu.imau.redpioneer.service.commonservice;

public interface ApproveService {
    int developmentApproved(Integer id,String remark);

    int prizeApproved(Integer id);

    int conversationApproved(Integer id);

    int talkApproved(Integer id);

    int scoreApproved(Integer id);


}
