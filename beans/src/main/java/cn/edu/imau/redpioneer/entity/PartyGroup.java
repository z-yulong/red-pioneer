package cn.edu.imau.redpioneer.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Table(name = "party_group")
public class PartyGroup {
    /**
     * 党小组表主键
     */
    @Id
    private Integer id;

    /**
     * 党小组名称
     */
    @Column(name = "group_name")
    private String groupName;

    /**
     * 负责人id
     */
    @Column(name = "activist_id")
    private Integer activistId;

    /**
     * 所在支部
     */
    private Integer branch;


}