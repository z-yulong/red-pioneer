package cn.edu.imau.redpioneer.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

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

    /**
     * 获取支部表主键
     *
     * @return id - 支部表主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置支部表主键
     *
     * @param id 支部表主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取支部名称
     *
     * @return branch_name - 支部名称
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * 设置支部名称
     *
     * @param branchName 支部名称
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /**
     * 获取负责人id
     *
     * @return activist_id - 负责人id
     */
    public Integer getActivistId() {
        return activistId;
    }

    /**
     * 设置负责人id
     *
     * @param activistId 负责人id
     */
    public void setActivistId(Integer activistId) {
        this.activistId = activistId;
    }
}