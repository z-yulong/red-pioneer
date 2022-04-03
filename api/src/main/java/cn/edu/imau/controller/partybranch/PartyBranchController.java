package cn.edu.imau.controller.partybranch;

import cn.edu.imau.redpioneer.entity.PartyGroup;
import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.service.commonservice.PartyBranchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zyl
 * @date 2022/1/4 17:18
 */

@CrossOrigin//解决跨域访问
@RestController
@RequestMapping("/branch")
@Api(value = "提供党支部操作接口",tags = "党支部管理")
public class PartyBranchController {

    @Autowired
    PartyBranchService partyBranchService;
    /**
     * 新建党小组
     * @param partyGroup
     * @return
     */
    @ApiOperation("新建一个党小组")
    @RequiresRoles("shuji")
    @PostMapping("/addPartyGroup")
    public ResultVO addPartyGroup(@RequestBody PartyGroup partyGroup, HttpServletRequest request) {
        return partyBranchService.addPartyGroup(partyGroup,request);
    }

    /**
     * 根据id删除党小组
     * @param id
     * @return
     */
    @ApiOperation("通过id删除党小组")
    @RequiresRoles("shuji")
    @DeleteMapping("/delete/{id}")
    public ResultVO deletePartyGroup(@PathVariable("id") Integer id) {
        return partyBranchService.deletePartyGroupById(id);
    }

    /**
     * 通过id更新党小组信息
     * @param partyGroup
     * @return
     */
    @ApiOperation(value = "通过id更新党小组信息接口")
    @RequiresRoles("shuji")
    @PutMapping("/update")
    public ResultVO updatePartyGroup(@RequestBody PartyGroup partyGroup){
        return partyBranchService.updatePartyGroupById(partyGroup);
    }

    /**
     * 获取自己支部下所有党小组
     * @return
     */
    @ApiOperation(value = "获取自己支部下所有党小组")
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji"})
    @GetMapping("/getAll")
    public ResultVO getAllPartyGroup(HttpServletRequest request){
        return partyBranchService.getAllPartyGroup(request);
    }

    /**
     * 获取待审批的用户(审批是否可以推重点对象)
     * @return
     */
    @ApiOperation(value = "获取待审批的用户(审批是否可以推重点对象)")
    @RequiresRoles("shuji")
    @GetMapping("/getAllPending")
    public ResultVO getAllPending(HttpServletRequest request){
        return partyBranchService.getAllPending(request);
    }

    /**
     * 审批通过
     */
    @ApiOperation(value = "审批通过")
    @RequiresRoles("shuji")
    @PutMapping("/approveFocus/{id}")
    public ResultVO approved(@PathVariable("id")Integer id,String remark,HttpServletRequest request){
        return partyBranchService.approved(id,remark,request);
    }

    /**
     * 审批未通过
     */
    @ApiOperation(value = "审批通过")
    @RequiresRoles("shuji")
    @PutMapping("/failFocus/{id}")
    public ResultVO fail(@PathVariable("id")Integer id,String remark,HttpServletRequest request){
        return partyBranchService.fail(id,remark,request);
    }


    /**
     * 获取支部人数
     * @return
     */
//    @ApiOperation(value = "获取支部人数")
//    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
//    @GetMapping("/getBranchNum/{id}")
//    public ResultVO getBranchNum(@PathVariable("id") Integer id){
//        return partyBranchService.getBranchNum(id);
//    }
    @ApiOperation(value = "获取支部人数")
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @GetMapping("/getBranchNum")
    public ResultVO getBranchNum(){
        return partyBranchService.getBranchNum();
    }

    /**
     * 获取支部各名民族人数
     * @return
     */
    @ApiOperation(value = "获取支部各名民族人数")
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @GetMapping("/getBranchNationNum")
    public ResultVO getBranchNationNum(){
        return partyBranchService.getBranchNationNum();
    }
    /**
     * 获取支部各性别人数
     * @return
     */
    @ApiOperation(value = "获取支部各性别人数")
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @GetMapping("/getBranchSexNum")
    public ResultVO getBranchSexNum(){
        return partyBranchService.getBranchSexNum();
    }

    /**
     * 获取支部各年级人数
     * @return
     */
    @ApiOperation(value = "获取支部各年级人数")
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @GetMapping("/getBranchGradeNum")
    public ResultVO getBranchGradeNum(){
        return partyBranchService.getBranchGradeNum();
    }


}
