package cn.edu.imau.redpioneer.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Conversation {
    /**
     * 志愿服务表主键
     */
    @Id
    private Integer id;

    /**
     * 服务地点
     */
    @Column(name = "volunteer_address")
    private String volunteerAddress;

    /**
     * 服务时间
     */
    @Column(name = "volunteer_time")
    private Date volunteerTime;

    /**
     * 服务内容
     */
    @Column(name = "volunteer_info")
    private String volunteerInfo;

    /**
     * 服务时长
     */
    @Column(name = "volunteer_size")
    private String volunteerSize;

    /**
     * 佐证材料
     */
    private String prove;

    /**
     * 用户id
     */
    @Column(name = "activist_id")
    private Integer activistId;

    /**
     * 获取志愿服务表主键
     *
     * @return id - 志愿服务表主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置志愿服务表主键
     *
     * @param id 志愿服务表主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取服务地点
     *
     * @return volunteer_address - 服务地点
     */
    public String getVolunteerAddress() {
        return volunteerAddress;
    }

    /**
     * 设置服务地点
     *
     * @param volunteerAddress 服务地点
     */
    public void setVolunteerAddress(String volunteerAddress) {
        this.volunteerAddress = volunteerAddress;
    }

    /**
     * 获取服务时间
     *
     * @return volunteer_time - 服务时间
     */
    public Date getVolunteerTime() {
        return volunteerTime;
    }

    /**
     * 设置服务时间
     *
     * @param volunteerTime 服务时间
     */
    public void setVolunteerTime(Date volunteerTime) {
        this.volunteerTime = volunteerTime;
    }

    /**
     * 获取服务内容
     *
     * @return volunteer_info - 服务内容
     */
    public String getVolunteerInfo() {
        return volunteerInfo;
    }

    /**
     * 设置服务内容
     *
     * @param volunteerInfo 服务内容
     */
    public void setVolunteerInfo(String volunteerInfo) {
        this.volunteerInfo = volunteerInfo;
    }

    /**
     * 获取服务时长
     *
     * @return volunteer_size - 服务时长
     */
    public String getVolunteerSize() {
        return volunteerSize;
    }

    /**
     * 设置服务时长
     *
     * @param volunteerSize 服务时长
     */
    public void setVolunteerSize(String volunteerSize) {
        this.volunteerSize = volunteerSize;
    }

    /**
     * 获取佐证材料
     *
     * @return prove - 佐证材料
     */
    public String getProve() {
        return prove;
    }

    /**
     * 设置佐证材料
     *
     * @param prove 佐证材料
     */
    public void setProve(String prove) {
        this.prove = prove;
    }

    /**
     * 获取用户id
     *
     * @return activist_id - 用户id
     */
    public Integer getActivistId() {
        return activistId;
    }

    /**
     * 设置用户id
     *
     * @param activistId 用户id
     */
    public void setActivistId(Integer activistId) {
        this.activistId = activistId;
    }
}