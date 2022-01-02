package cn.edu.imau.controller.partybranchcontroller;

import cn.edu.imau.redpioneer.entity.PartyBranch;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.service.commonservice.PartyBranchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zyl
 * @date 2021/12/8 21:44
 */

@CrossOrigin//解决跨域访问
@RestController
@RequestMapping("/branch")
@Api(value = "提供党支部信息接口",tags = "党支部管理")
public class PartyBranchController {

    @Autowired
    PartyBranchService partyBranchService;

    /**
     * 新建党支部
     * @param partyBranch
     * @return
     */
    @PostMapping("/addPartyBranch")
    @ApiOperation("新建一个党支部")
    @RequiresRoles("admin")
    public ResultVO addPartyBranch(@RequestBody PartyBranch partyBranch) {
        return partyBranchService.addPartyBranch(partyBranch);
    }


}
