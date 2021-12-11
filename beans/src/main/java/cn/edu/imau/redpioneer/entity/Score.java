package cn.edu.imau.redpioneer.entity;

import javax.persistence.*;

public class Score {
    /**
     * 成绩表主键
     */
    @Id
    private Integer id;

    /**
     * 用户表主键
     */
    @Column(name = "activist_id")
    private Integer activistId;

    /**
     * 智育成绩
     */
    private String moral;

    /**
     * 综测成绩
     */
    private String comprehensive;

    /**
     * 智育排名
     */
    @Column(name = "moral_ranking")
    private String moralRanking;

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
}