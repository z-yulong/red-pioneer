package cn.edu.imau.controller.activist;

import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.service.userservice.DevelopmentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * @author: zyl
 * @date 2021/12/30 13:25
 */
@CrossOrigin
@RestController
@ResponseBody
@RequestMapping("/development")
@Api(value = "提供用户发展信息操作接口",tags = "发展信息")
public class DevelopmentInfoController {

    private DevelopmentInfoService developmentInfoService;
    @Autowired
    public DevelopmentInfoController(DevelopmentInfoService developmentInfoService) {
        this.developmentInfoService = developmentInfoService;
    }

    /**
     * 上传积极分子结业信息接口
     * @param upactivistTime 确定为积极分子时间
     * @param diploma 积极分子结业证
     * @param request
     * @return
     * @throws IOException
     */
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "上传积极分子结业信息接口")
    @PostMapping("/uploadDiploma")
    public ResultVO uploadRdsq(
            @RequestParam("upactivistTime") @DateTimeFormat(pattern="yyyy-MM-dd") Date upactivistTime, MultipartFile diploma, ServletRequest request) throws IOException {
        return developmentInfoService.uploadDiploma(upactivistTime,diploma,request);
    }

    /**
     * 上传入党申请书接口
     * @param applicationTime
     * @param applicationForm
     * @param request
     * @return
     * @throws IOException
     */
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "上传入党申请书接口")
    @PostMapping("/uploadApplication")
    public ResultVO uploadApplication(
            @RequestParam("applicationTime") @DateTimeFormat(pattern="yyyy-MM-dd") Date applicationTime, MultipartFile applicationForm,ServletRequest request) throws IOException {
        return developmentInfoService.uploadApplication (applicationTime,applicationForm,request);
    }

    /**
     * 通过姓名或账号查询用户发展信息
     * @param info
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "通过姓名或账号查询用户发展信息")
    @GetMapping("/getDevelopmentInfo")
    public ResultVO getDevelopmentInfo(@RequestParam("info")String info){
        return developmentInfoService.getDevelopmentInfo(info);
    }

    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "通过id查看发展信息")
    @GetMapping("/getDevelopment/{id}")
    public ResultVO getDevelopmentInfoById(@PathVariable("id")Integer id){
        return developmentInfoService.getDevelopmentInfoById(id);
    }

    /**
     * 删除用户发展信息接口
     * @param id
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "删除用户发展信息接口")
    @DeleteMapping("/deleteDevelopment/{id}")
    public ResultVO deletePrize(@PathVariable("id") Integer id){
        return developmentInfoService.deleteDevelopmentById(id);
    }




}
