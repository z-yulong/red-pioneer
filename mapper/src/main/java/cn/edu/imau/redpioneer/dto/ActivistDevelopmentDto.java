package cn.edu.imau.redpioneer.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author: zyl
 * @date 2022/1/1 18:31
 */
@Data
public class ActivistDevelopmentDto {
    private String name;
    private Date applicationTime;
    private String applicationForm;
    private String diploma;
    private Date upactivistTime;
    /**
     * 备注
     */
    private String remark;

    /**
     * 状态
     */
    @Column(name = "state_code")
    private Integer stateCode;
}
