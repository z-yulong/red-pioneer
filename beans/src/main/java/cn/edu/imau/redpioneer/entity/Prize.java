package cn.edu.imau.redpioneer.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Prize {
    /**
     * 奖惩信息表主键
     */
    @Id
    private Integer id;

    /**
     * 奖惩信息
     */
    @Column(name = "prize_info")
    private String prizeInfo;

    /**
     * 奖惩时间
     */
    @Column(name = "prize_time")
    private Date prizeTime;

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
     * 获取奖惩信息表主键
     *
     * @return id - 奖惩信息表主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置奖惩信息表主键
     *
     * @param id 奖惩信息表主键
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取奖惩时间
     *
     * @return prize_time - 奖惩时间
     */
    public Date getPrizeTime() {
        return prizeTime;
    }

    /**
     * 设置奖惩时间
     *
     * @param prizeTime 奖惩时间
     */
    public void setPrizeTime(Date prizeTime) {
        this.prizeTime = prizeTime;
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