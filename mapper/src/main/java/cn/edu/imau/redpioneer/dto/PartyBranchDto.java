package cn.edu.imau.redpioneer.dto;

import lombok.Data;
import sun.net.TelnetInputStream;

/**
 * @author: zyl
 * @date 2022/1/4 14:52
 */
@Data
public class PartyBranchDto {

    /**
     * 支部名称
     */
    private String branchName;
    /**
     * 负责人姓名
     */
    private String name;
    /**
     * 负责人电话
     */
    private String tel;
}
