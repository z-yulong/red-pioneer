package cn.edu.imau.redpioneer.dto;

import cn.edu.imau.redpioneer.entity.ActivistPrizeInfo;
import cn.edu.imau.redpioneer.entity.Prize;
import lombok.Data;
import java.util.List;

@Data
public class PrizeDto extends Prize {
    private List<ActivistPrizeInfo> PrizeInfos;
}
