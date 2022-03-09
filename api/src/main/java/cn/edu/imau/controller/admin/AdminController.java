package cn.edu.imau.controller.admin;

import cn.edu.imau.redpioneer.entity.PartyBranch;
import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.service.commonservice.ActivistService;
import cn.edu.imau.redpioneer.service.commonservice.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zyl
 * @date 2021/12/8 21:44
 */

@CrossOrigin//解决跨域访问
@RestController
@RequestMapping("/admin")
@Api(value = "提供管理员操作接口",tags = "管理员管理")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    ActivistService activistService;
    /**
     * 新建党支部
     * @param partyBranch
     * @return
     */
    @ApiOperation("新建一个党支部")
    @RequiresRoles("admin")
    @PostMapping("/addPartyBranch")
    public ResultVO addPartyBranch(@RequestBody PartyBranch partyBranch) {
        return adminService.addPartyBranch(partyBranch);
    }

    /**
     * 通过id删除支部
     * @param id
     * @return
     */
    @ApiOperation("通过id删除支部")
    @RequiresRoles("admin")
    @DeleteMapping("/delete/{id}")
    public ResultVO deletePartyBranch(@PathVariable("id") Integer id) {
        return adminService.deletePartyBranchById(id);
    }

    /**
     * 通过id更新支部信息
     * @param partyBranch
     * @param request
     * @return
     */
    @ApiOperation(value = "更新支部信息接口")
    @RequiresRoles("admin")
    @PutMapping("/update")
    public ResultVO updatePartyBranch(@RequestBody PartyBranch partyBranch, HttpServletRequest request){
        return adminService.updatePartyBranch(partyBranch,request);
    }

    /**
     * 获取所有支部
     * @return
     */
    @ApiOperation(value = "获取所有支部接口")
    @RequiresRoles("admin")
    @GetMapping("/getAll")
    public ResultVO getAllPartyBranch(){
        return adminService.getAllPartyBranch();
    }

    /**
     * 通过角色查询支部负责人
     * @param
     * @return
     */
    @ApiOperation("通过角色查询支部负责人")
    @RequiresRoles("admin")
    @GetMapping("/getUserByRole")
    public ResultVO getUserByRole() {
        return activistService.getUserByRole();
    }
}
