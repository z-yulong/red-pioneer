package cn.edu.imau.redpioneer.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Table(name = "party_branch")
public class PartyBranch {
    /**
     * 支部表主键
     */
    @Id
    private Integer id;

    /**
     * 支部名称
     */
    @Column(name = "branch_name")
    private String branchName;

    /**
     * 负责人id
     */
    @Column(name = "activist_id")
    private Integer activistId;

}