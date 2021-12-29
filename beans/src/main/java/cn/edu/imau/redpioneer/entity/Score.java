package cn.edu.imau.redpioneer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
     * 是否前1/2
     */
    @Column(name = "is_firsthalf")
    private String isFirsthalf;


}