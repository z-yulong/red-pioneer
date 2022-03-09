package cn.edu.imau.redpioneer.service.commonservice;

import cn.edu.imau.redpioneer.vo.ResultVO;

public interface FaliService {
    int developmentFail(Integer id, String remark);

    int prizeFail(Integer id);

    int conversationFail(Integer id);

    int talkFail(Integer id);

    int scoreFail(Integer id);
}
