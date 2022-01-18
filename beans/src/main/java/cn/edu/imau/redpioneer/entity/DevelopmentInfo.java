package cn.edu.imau.redpioneer.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Data
@Table(name = "development_info")
public class DevelopmentInfo {
    /**
     * 发展信息表主键
     */
    @Id
    private Integer id;

    /**
     * 入党申请时间
     */
    @Column(name = "application_time")
    private Date applicationTime;

    /**
     * 入党申请书
     */
    @Column(name = "application_form")
    private String applicationForm;

    /**
     * 积极分子结业证
     */
    private String diploma;

    /**
     * 确定为积极分子时间
     */
    @Column(name = "upactivist_time")
    private Date upactivistTime;

    /**
     * 积极分子id
     */
    @Column(name = "activist_id")
    private Integer activistId;

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