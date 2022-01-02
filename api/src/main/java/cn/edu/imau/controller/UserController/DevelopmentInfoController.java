package cn.edu.imau.controller.UserController;

import cn.edu.imau.redpioneer.enums.ResultVO;
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

    @Autowired
    DevelopmentInfoService developmentInfoService;

    /**
     * 上传发展信息
     * @param applicationTime 入党申请时间
     * @param applicationForm 入党申请书
     * @param upactivistTime 确定为积极分子时间
     * @param diploma 积极分子结业证
     * @param request
     * @return
     * @throws IOException
     */
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "上传入党申请信息接口")
    @PostMapping("/uploadRdsq")
    public ResultVO uploadRdsq(
            @RequestParam("applicationTime") @DateTimeFormat(pattern="yyyy-MM-dd") Date applicationTime, MultipartFile applicationForm,
            @RequestParam("upactivistTime") @DateTimeFormat(pattern="yyyy-MM-dd") Date upactivistTime, MultipartFile diploma, ServletRequest request) throws IOException {
        return developmentInfoService.uploadRdsq(applicationTime,applicationForm,upactivistTime,diploma,request);
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

}
