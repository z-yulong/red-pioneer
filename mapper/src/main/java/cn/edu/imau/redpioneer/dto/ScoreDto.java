package cn.edu.imau.redpioneer.dto;

import lombok.Data;

/**
 * @author: zyl
 * @date 2022/2/5 12:38
 */
@Data
public class ScoreDto {
    private Integer id;
    private String name;
    private String moral;
    private String moralRanking;
    private String comprehensive;
    private String comprehensiveRanking;
    private String classSize;
    private Integer isFirsthalf;
    private String stateCode;

}
