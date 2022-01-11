package cn.edu.imau.redpioneer.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;
@Data
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

}