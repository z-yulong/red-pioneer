package cn.edu.imau.controller.UserController;

import cn.edu.imau.redpioneer.entity.Score;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.service.userservice.UserService;
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
 *
 * @author: zyl
 * @date 2021/12/11 12:33
 */

@CrossOrigin//解决跨域访问
@RestController
@RequestMapping("/user")
@Api(value = "提供普通用户操作接口",tags = "普通用户操作")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 上传上传奖惩信息
     * @param prizeImg
     * @param date
     * @param level
     * @param request
     * @throws IOException
     */
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "上传奖惩信息接口")
    @PutMapping("/addPrize")
    public ResultVO addPrizeImg(@RequestParam("prizeImg") MultipartFile prizeImg
            , @RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date
                                ,@RequestParam("level")String level,ServletRequest request) throws IOException {
        return userService.addprize(prizeImg,date,level,request);
    }

    /**
     * 获取用户惩信息
     * @param request
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "获取用户惩信息接口")
    @GetMapping("/getPrize")
    public ResultVO getPrize(ServletRequest request){
        return userService.getPrize(request);
    }

    /**
     * 上传成绩
     * @param request
     * @return
     */
    @RequiresRoles("user")
    @ApiOperation(value = "上传成绩接口")
    @PostMapping("/addScore")
    public ResultVO addScore(@RequestBody Score score,ServletRequest request){

        return userService.addScore(score,request);
    }

}
