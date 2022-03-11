package cn.edu.imau.redpioneer.dto;

import lombok.Data;

/**
 * @author: zyl
 * @date 2022/1/19 12:01
 */
@Data
public class TotalDto {
    private Integer id; //用户表主键
    private Integer total;
    private String name;
}
