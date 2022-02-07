package cn.edu.imau.redpioneer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author: zyl
 * @date 2022/1/1 14:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ActivistPrizeDto {
    private Integer id;
    private String name;
    private String prizeInfo;
    private Date prizeTime;
    private String prove;

}
