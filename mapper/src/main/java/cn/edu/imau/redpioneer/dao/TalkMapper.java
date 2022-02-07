package cn.edu.imau.redpioneer.dao;

import cn.edu.imau.redpioneer.dto.TalkDto;
import cn.edu.imau.redpioneer.dto.TalkNumDto;
import cn.edu.imau.redpioneer.entity.Talk;
import cn.edu.imau.redpioneer.general.GeneralDAO;

import java.util.List;

public interface TalkMapper extends GeneralDAO<Talk> {

    List<TalkNumDto> selectTalkNum(Integer type);

    List<TalkDto> selectTalkByState(Integer state,Integer id);
}