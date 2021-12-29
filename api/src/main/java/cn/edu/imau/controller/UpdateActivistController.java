package cn.edu.imau.controller;

import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.service.UpdateActivistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: zyl
 * @date 2021/11/11 15:51
 */

@CrossOrigin//解决跨域访问
@RestController
@RequestMapping("/center")
@Api(value = "个人中心接口",tags = "个人信息接口")
public class UpdateActivistController {
    @Resource
    private UpdateActivistService updateActivistService;


    @RequiresRoles(logical = Logical.OR, value = {"管理员","党支部书记","党小组组长","积极分子"})
    @ApiOperation(value = "修改个人信息接口")
    @PutMapping("/update")
    public ResultVO updateUser(@RequestBody Activist activist){
        return updateActivistService.updateActivistInfo(activist);
    }

    /**
     *
     * @param avater
     * @param request
     * @return
     * @throws IOException
     */
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "修改头像接口")
    @PutMapping("/avater")
    public ResultVO updateAvater(@RequestParam("avater") MultipartFile avater, ServletRequest request) throws IOException {
        return updateActivistService.updateActivistAvatar(avater,request);
    }

//    @ApiOperation(value = "update")
//    @RequiresRoles("admin")
//    @RequiresPermissions("200")
//    @PutMapping("/updatetest")
//    public ResultVO update(){
//        return new ResultVO(ResStatus.OK.getValue(),ResStatus.OK.getText(), null);
//    }

}
