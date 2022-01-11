package cn.edu.imau.redpioneer.dto;

import cn.edu.imau.redpioneer.entity.PartyBranch;
import cn.edu.imau.redpioneer.entity.PartyBranchInfo;
import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @author: zyl
 * @date 2022/1/4 14:55
 */
@Data
public class PartyBranchDto extends PartyBranch {
    private List<PartyBranchInfo> partyBranchInfos;
}
