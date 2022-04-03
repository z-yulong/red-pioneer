package cn.edu.imau.controller.partygroup;

import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.entity.Train;
import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.service.commonservice.PartyGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zyl
 * @date 2022/1/6 15:03
 */

@CrossOrigin//解决跨域访问
@RestController
@RequestMapping("/group")
@Api(value = "提供党小组操作接口",tags = "党小组管理")
public class PartyGroupController {

    @Autowired
    PartyGroupService partyGroupService;

    @ApiOperation("添加培养人")
    @RequiresRoles("zuzhang")
    @PostMapping("/addTrain")
    public ResultVO addTrain(@RequestBody Train train, HttpServletRequest request){
        return partyGroupService.addTrain(train,request);
    }

    /**
     * 通过id删除培养人
     * @param id
     * @return
     */
    @ApiOperation("通过id删除培养人")
    @RequiresRoles("zuzhang")
    @DeleteMapping("/delete/{id}")
    public ResultVO deleteTrain(@PathVariable("id") Integer id) {
        return partyGroupService.deleteTrainById(id);
    }

    /**
     * 通过id更新培养人信息
     * @param train
     * @return
     */
    @ApiOperation(value = "通过id更新培养人信息")
    @RequiresRoles("zuzhang")
    @PutMapping("/update")
    public ResultVO updatePartyGroup(@RequestBody Train train){
        return partyGroupService.updateTrainById(train);
    }

    /**
     * 获取自己小组下所有培养人
     * @return
     */
    @ApiOperation(value = "获取自己小组下所有培养人")
    @RequiresRoles("zuzhang")
    @GetMapping("/getAll")
    public ResultVO getAllTrain(HttpServletRequest request){
        return partyGroupService.getAllTrain(request);
    }

    /**
     * 通过id修改积极分子信息，培养人分配
     * @return
     */
    @ApiOperation(value = "通过id修改积极分子信息，培养人分配")
    @RequiresRoles("zuzhang")
    @PutMapping("/updateActivist")
    public ResultVO updateActivist(@RequestBody Activist activist){
        return partyGroupService.updateActivist(activist);
    }


    /**
     * 获取自己小组下所有人
     * @return
     */
    @ApiOperation(value = "获取自己小组下所有培养人")
    @RequiresRoles("zuzhang")
    @GetMapping("/getAllActivist")
    public ResultVO getAllActivist(HttpServletRequest request){
        return partyGroupService.getAllActivist(request);
    }

    /**
     * 通过id获取小组下所有人
     * @return
     */
    @ApiOperation(value = "通过id获取小组下所有人")
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang"})
    @GetMapping("/getAllActivistById/{id}")
    public ResultVO getAllActivistById(@PathVariable Integer id){
        return partyGroupService.getAllActivistById(id);
    }

    /**************************************************************************************************************************/

    /**
     * 获取党小组人数
     * @return
     */
    @ApiOperation(value = "获取党小组人数")
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @GetMapping("/getGroupNum")
    public ResultVO getGroupNum(HttpServletRequest request){
        return partyGroupService.getGroupNum(request);
    }

    /**
     * 获取党小组各名民族人数
     * @return
     */
    @ApiOperation(value = "获取党小组各名民族人数")
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @GetMapping("/getGroupNationNum")
    public ResultVO getGroupNationNum(HttpServletRequest request){
        return partyGroupService.getGroupNationNum(request);
    }
    /**
     * 获取党小组各性别人数
     * @return
     */
    @ApiOperation(value = "获取党小组各性别人数")
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @GetMapping("/getGroupSexNum")
    public ResultVO getGroupSexNum(HttpServletRequest request){
        return partyGroupService.getGroupSexNum(request);
    }

    /**
     * 获取党小组各年级人数
     * @return
     */
    @ApiOperation(value = "获取党小组各年级人数")
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @GetMapping("/getGroupGradeNum")
    public ResultVO getGroupGradeNum(HttpServletRequest request){
        return partyGroupService.getGroupGradeNum(request);
    }




}
