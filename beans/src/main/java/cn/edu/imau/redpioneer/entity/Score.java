package cn.edu.imau.redpioneer.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
@Data
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
    private Integer isFirsthalf;

    /**
     * 用户id
     */
    @Column(name = "activist_id")
    private Integer activistId;


    /**
     * 状态
     */
    @Column(name = "state_code")
    private Integer stateCode;

}