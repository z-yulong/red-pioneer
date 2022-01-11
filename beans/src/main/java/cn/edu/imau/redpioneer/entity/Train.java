package cn.edu.imau.redpioneer.entity;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;
@Data
public class Train {
    /**
     * 培养人表主键
     */
    @Id
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 联系方式
     */
    private String tel;

    /**
     * 党小组表主键
     */
    @Column(name = "party_group_id")
    private Integer partyGroupId;

    /**
     * 入党时间
     */
    @Column(name = "party_time")
    private Date partyTime;

}