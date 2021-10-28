package cn.deu.imau.redpioneer.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Volunteer {
    /**
     * 谈话表id
     */
    @Id
    private Integer id;

    @Column(name = "activist_id")
    private Integer activistId;

    /**
     * 佐证材料
     */
    private String prove;

    /**
     * 上传时间
     */
    @Column(name = "`upload time`")
    private Date uploadTime;

    /**
     * 谈话人
     */
    private Integer volunteer;

    /**
     * 获取谈话表id
     *
     * @return id - 谈话表id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置谈话表id
     *
     * @param id 谈话表id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return activist_id
     */
    public Integer getActivistId() {
        return activistId;
    }

    /**
     * @param activistId
     */
    public void setActivistId(Integer activistId) {
        this.activistId = activistId;
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
     * 获取上传时间
     *
     * @return upload time - 上传时间
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * 设置上传时间
     *
     * @param uploadTime 上传时间
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * 获取谈话人
     *
     * @return volunteer - 谈话人
     */
    public Integer getVolunteer() {
        return volunteer;
    }

    /**
     * 设置谈话人
     *
     * @param volunteer 谈话人
     */
    public void setVolunteer(Integer volunteer) {
        this.volunteer = volunteer;
    }
}