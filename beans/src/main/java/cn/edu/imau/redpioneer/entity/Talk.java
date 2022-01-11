package cn.edu.imau.redpioneer.entity;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;
@Data
public class Talk {
    /**
     * 谈话表主键
     */
    @Id
    private Integer id;

    /**
     * 用户表主键
     */
    @Column(name = "activist_id")
    private Integer activistId;

    /**
     * 谈话时间
     */
    @Column(name = "talk_time")
    private Date talkTime;

    /**
     * 谈话人
     */
    @Column(name = "talk_people")
    private String talkPeople;

    /**
     * 佐证材料
     */
    private String prove;

    @Column(name = "talk_type")
    private Integer talkType;

    /**
     * 谈话状态（默认为2,待审批）0：未通过；1：通过
     */
    @Column(name = "talk_state")
    private Integer talkState;


}