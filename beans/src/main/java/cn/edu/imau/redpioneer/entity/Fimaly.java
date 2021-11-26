package cn.edu.imau.redpioneer.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Fimaly {
    @Id
    private Integer id;

    /**
     * 关系
     */
    private String relation;

    /**
     * 积极分子id
     */
    @Column(name = "activist_id")
    private Integer activistId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 出生日期
     */
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    /**
     * 政治面貌
     */
    private String political;

    /**
     * 职业
     */
    private String job;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取关系
     *
     * @return relation - 关系
     */
    public String getRelation() {
        return relation;
    }

    /**
     * 设置关系
     *
     * @param relation 关系
     */
    public void setRelation(String relation) {
        this.relation = relation;
    }

    /**
     * 获取积极分子id
     *
     * @return activist_id - 积极分子id
     */
    public Integer getActivistId() {
        return activistId;
    }

    /**
     * 设置积极分子id
     *
     * @param activistId 积极分子id
     */
    public void setActivistId(Integer activistId) {
        this.activistId = activistId;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取出生日期
     *
     * @return date_of_birth - 出生日期
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * 设置出生日期
     *
     * @param dateOfBirth 出生日期
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * 获取政治面貌
     *
     * @return political - 政治面貌
     */
    public String getPolitical() {
        return political;
    }

    /**
     * 设置政治面貌
     *
     * @param political 政治面貌
     */
    public void setPolitical(String political) {
        this.political = political;
    }

    /**
     * 获取职业
     *
     * @return job - 职业
     */
    public String getJob() {
        return job;
    }

    /**
     * 设置职业
     *
     * @param job 职业
     */
    public void setJob(String job) {
        this.job = job;
    }
}