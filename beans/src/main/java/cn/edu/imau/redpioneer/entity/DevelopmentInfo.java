package cn.edu.imau.redpioneer.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "development_info")
public class DevelopmentInfo {
    /**
     * 发展信息表主键
     */
    @Id
    private Integer id;

    /**
     * 入党申请时间
     */
    @Column(name = "application_time")
    private Date applicationTime;

    /**
     * 入党申请书
     */
    @Column(name = "application_form")
    private String applicationForm;

    /**
     * 积极分子结业证
     */
    private String diploma;

    /**
     * 确定为积极分子时间
     */
    @Column(name = "upactivist_time")
    private String upactivistTime;

    /**
     * 积极分子id
     */
    @Column(name = "activist_id")
    private Integer activistId;

    /**
     * 获取发展信息表主键
     *
     * @return id - 发展信息表主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置发展信息表主键
     *
     * @param id 发展信息表主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取入党申请时间
     *
     * @return application_time - 入党申请时间
     */
    public Date getApplicationTime() {
        return applicationTime;
    }

    /**
     * 设置入党申请时间
     *
     * @param applicationTime 入党申请时间
     */
    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    /**
     * 获取入党申请书
     *
     * @return application_form - 入党申请书
     */
    public String getApplicationForm() {
        return applicationForm;
    }

    /**
     * 设置入党申请书
     *
     * @param applicationForm 入党申请书
     */
    public void setApplicationForm(String applicationForm) {
        this.applicationForm = applicationForm;
    }

    /**
     * 获取积极分子结业证
     *
     * @return diploma - 积极分子结业证
     */
    public String getDiploma() {
        return diploma;
    }

    /**
     * 设置积极分子结业证
     *
     * @param diploma 积极分子结业证
     */
    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    /**
     * 获取确定为积极分子时间
     *
     * @return upactivist_time - 确定为积极分子时间
     */
    public String getUpactivistTime() {
        return upactivistTime;
    }

    /**
     * 设置确定为积极分子时间
     *
     * @param upactivistTime 确定为积极分子时间
     */
    public void setUpactivistTime(String upactivistTime) {
        this.upactivistTime = upactivistTime;
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
}