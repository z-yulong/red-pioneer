package cn.edu.imau.redpioneer.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Score {
    /**
     * 成绩表主键
     */
    @Id
    private Integer id;

    /**
     * 智育成绩
     */
    private String moral;

    /**
     * 智育排名
     */
    @Column(name = "moral_ranking")
    private String moralRanking;

    /**
     * 综测成绩
     */
    private String comprehensive;

    /**
     * 综测排名
     */
    @Column(name = "comprehensive_ranking")
    private String comprehensiveRanking;

    /**
     * 班级人数
     */
    @Column(name = "class_size")
    private String classSize;

    /**
     * 是否前1/2
     */
    @Column(name = "is_firsthalf")
    private String isFirsthalf;

    /**
     * 用户id
     */
    @Column(name = "activist_id")
    private Integer activistId;

    /**
     * 获取成绩表主键
     *
     * @return id - 成绩表主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置成绩表主键
     *
     * @param id 成绩表主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取智育成绩
     *
     * @return moral - 智育成绩
     */
    public String getMoral() {
        return moral;
    }

    /**
     * 设置智育成绩
     *
     * @param moral 智育成绩
     */
    public void setMoral(String moral) {
        this.moral = moral;
    }

    /**
     * 获取智育排名
     *
     * @return moral_ranking - 智育排名
     */
    public String getMoralRanking() {
        return moralRanking;
    }

    /**
     * 设置智育排名
     *
     * @param moralRanking 智育排名
     */
    public void setMoralRanking(String moralRanking) {
        this.moralRanking = moralRanking;
    }

    /**
     * 获取综测成绩
     *
     * @return comprehensive - 综测成绩
     */
    public String getComprehensive() {
        return comprehensive;
    }

    /**
     * 设置综测成绩
     *
     * @param comprehensive 综测成绩
     */
    public void setComprehensive(String comprehensive) {
        this.comprehensive = comprehensive;
    }

    /**
     * 获取综测排名
     *
     * @return comprehensive_ranking - 综测排名
     */
    public String getComprehensiveRanking() {
        return comprehensiveRanking;
    }

    /**
     * 设置综测排名
     *
     * @param comprehensiveRanking 综测排名
     */
    public void setComprehensiveRanking(String comprehensiveRanking) {
        this.comprehensiveRanking = comprehensiveRanking;
    }

    /**
     * 获取班级人数
     *
     * @return class_size - 班级人数
     */
    public String getClassSize() {
        return classSize;
    }

    /**
     * 设置班级人数
     *
     * @param classSize 班级人数
     */
    public void setClassSize(String classSize) {
        this.classSize = classSize;
    }

    /**
     * 获取是否前1/2
     *
     * @return is_firsthalf - 是否前1/2
     */
    public String getIsFirsthalf() {
        return isFirsthalf;
    }

    /**
     * 设置是否前1/2
     *
     * @param isFirsthalf 是否前1/2
     */
    public void setIsFirsthalf(String isFirsthalf) {
        this.isFirsthalf = isFirsthalf;
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