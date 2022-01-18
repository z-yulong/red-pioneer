package cn.edu.imau.redpioneer.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author: zyl
 * @date 2022/1/2 11:57
 */
@Data
public class ActivistConversationDto {

    private String name;
    private String volunteerInfo;
    private String volunteerAddress;
    private Date volunteerTime;
    private String volunteerSize;
    private String prove;
}
