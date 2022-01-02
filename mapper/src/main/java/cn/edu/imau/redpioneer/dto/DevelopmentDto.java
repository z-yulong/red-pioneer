package cn.edu.imau.redpioneer.dto;

import cn.edu.imau.redpioneer.entity.DevelopmentInfo;
import lombok.Data;

/**
 * @author: zyl
 * @date 2022/1/1 18:22
 */
@Data
public class DevelopmentDto extends DevelopmentInfo {
    private DevelopmentInfo developmentInfo;
}
