package cn.edu.imau.redpioneer.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author: zyl
 * @date 2022/1/23 16:05
 */
@Data
public class TalkDto {
    private Integer id;
    private String name;
    private Date talkTime;
    private String talkPeople;
    private Integer talkType;
    private String prove;
    private Integer talkState;

}
