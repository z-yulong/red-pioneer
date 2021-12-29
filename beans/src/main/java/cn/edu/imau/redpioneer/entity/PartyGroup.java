package cn.edu.imau.redpioneer.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

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

    /**
     * 获取党小组表主键
     *
     * @return id - 党小组表主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置党小组表主键
     *
     * @param id 党小组表主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取党小组名称
     *
     * @return group_name - 党小组名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置党小组名称
     *
     * @param groupName 党小组名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    /**
     * 获取所在支部
     *
     * @return branch - 所在支部
     */
    public Integer getBranch() {
        return branch;
    }

    /**
     * 设置所在支部
     *
     * @param branch 所在支部
     */
    public void setBranch(Integer branch) {
        this.branch = branch;
    }
}