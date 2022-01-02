package cn.edu.imau.redpioneer.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: zyl
 * @date 2022/1/1 18:31
 */
@Data
public class ActivistDevelopmentInfo {
    private String name;
    private Date applicationTime;
    private String applicationForm;
    private String diploma;
    private Date upactivistTime;
}
