package cn.edu.imau.redpioneer.entity;

import java.util.Date;
import javax.persistence.*;

public class Prize {
    /**
     * 奖惩表主键
     */
    @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "activist_id")
    private Integer activistId;

    /**
     * 奖惩时间
     */
    @Column(name = "prize_date")
    private Date prizeDate;

    /**
     * 奖惩信息
     */
    @Column(name = "prize_info")
    private String prizeInfo;

    /**
     * 奖惩等级
     */
    @Column(name = "prize_level")
    private String prizeLevel;

    /**
     * 获取奖惩表主键
     *
     * @return id - 奖惩表主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置奖惩表主键
     *
     * @param id 奖惩表主键
     */
    public void setId(Integer id) {
        this.id = id;
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

    /**
     * 获取奖惩时间
     *
     * @return prize_date - 奖惩时间
     */
    public Date getPrizeDate() {
        return prizeDate;
    }

    /**
     * 设置奖惩时间
     *
     * @param prizeDate 奖惩时间
     */
    public void setPrizeDate(Date prizeDate) {
        this.prizeDate = prizeDate;
    }

    /**
     * 获取奖惩信息
     *
     * @return prize_info - 奖惩信息
     */
    public String getPrizeInfo() {
        return prizeInfo;
    }

    /**
     * 设置奖惩信息
     *
     * @param prizeInfo 奖惩信息
     */
    public void setPrizeInfo(String prizeInfo) {
        this.prizeInfo = prizeInfo;
    }

    /**
     * 获取奖惩等级
     *
     * @return prize_level - 奖惩等级
     */
    public String getPrizeLevel() {
        return prizeLevel;
    }

    /**
     * 设置奖惩等级
     *
     * @param prizeLevel 奖惩等级
     */
    public void setPrizeLevel(String prizeLevel) {
        this.prizeLevel = prizeLevel;
    }
}