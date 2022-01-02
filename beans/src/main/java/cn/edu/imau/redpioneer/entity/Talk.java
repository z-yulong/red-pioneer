package cn.edu.imau.redpioneer.entity;

import java.util.Date;
import javax.persistence.*;

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
    private Integer talkPeople;

    /**
     * 佐证材料
     */
    private String prove;

    /**
     * 获取谈话表主键
     *
     * @return id - 谈话表主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置谈话表主键
     *
     * @param id 谈话表主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户表主键
     *
     * @return activist_id - 用户表主键
     */
    public Integer getActivistId() {
        return activistId;
    }

    /**
     * 设置用户表主键
     *
     * @param activistId 用户表主键
     */
    public void setActivistId(Integer activistId) {
        this.activistId = activistId;
    }

    /**
     * 获取谈话时间
     *
     * @return talk_time - 谈话时间
     */
    public Date getTalkTime() {
        return talkTime;
    }

    /**
     * 设置谈话时间
     *
     * @param talkTime 谈话时间
     */
    public void setTalkTime(Date talkTime) {
        this.talkTime = talkTime;
    }

    /**
     * 获取谈话人
     *
     * @return talk_people - 谈话人
     */
    public Integer getTalkPeople() {
        return talkPeople;
    }

    /**
     * 设置谈话人
     *
     * @param talkPeople 谈话人
     */
    public void setTalkPeople(Integer talkPeople) {
        this.talkPeople = talkPeople;
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
}