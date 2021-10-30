package cn.edu.imau.controller;

import cn.deu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.service.UserService;
import cn.edu.imau.redpioneer.vo.ResultVO;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: zyl
 * @date 2021/10/28 17:08
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
@Api(value = "提供用户登录注册接口",tags = "用户管理")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "account",value = "用户名",required = true),
            @ApiImplicitParam(dataType = "String",name = "password",value = "密码",required = false,defaultValue = "888888")
    })
    @RequestMapping("/login")
    @GetMapping
    public ResultVO login(@RequestParam("account")String account,
                          @RequestParam(value = "password",defaultValue = "888888") String password){
        return userService.login(account,password);
    }


    @ApiOperation(value = "用户注册接口")
    @ApiImplicitParam
    @RequestMapping("/regist")
    @PostMapping
    public ResultVO regist(Activist activist){
        System.out.println("regist");
        return new ResultVO(10002,"sec",null);
    }




}
