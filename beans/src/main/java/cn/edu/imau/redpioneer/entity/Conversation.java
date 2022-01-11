package cn.edu.imau.redpioneer.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;
@Data
public class Conversation {
    /**
     * 志愿服务表主键
     */
    @Id
    private Integer id;

    /**
     * 服务地点
     */
    @Column(name = "volunteer_address")
    private String volunteerAddress;

    /**
     * 服务时间
     */
    @Column(name = "volunteer_time")
    private Date volunteerTime;

    /**
     * 服务内容
     */
    @Column(name = "volunteer_info")
    private String volunteerInfo;

    /**
     * 服务时长
     */
    @Column(name = "volunteer_size")
    private String volunteerSize;

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