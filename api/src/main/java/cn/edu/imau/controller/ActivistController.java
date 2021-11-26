package cn.edu.imau.controller;

import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.service.ActivistService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: zyl
 * @date 2021/10/28 17:08
 */
@CrossOrigin//解决跨域访问
@RestController
@RequestMapping("/user")
@Api(value = "提供用户登录注册接口",tags = "用户管理")
public class ActivistController {

    @Resource
    private ActivistService activistService;


    @ApiOperation(value = "用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "account",value = "用户名",required = true),
            @ApiImplicitParam(dataType = "String",name = "password",value = "密码",required = false,defaultValue = "888888")
    })
    //@RequestMapping(value = "/login",method = RequestMethod.GET)
    @GetMapping("/login")
    public ResultVO login(@RequestParam("account")String account,
                          @RequestParam(value = "password",defaultValue = "888888") String password){
        return activistService.login(account,password);
    }



    @ApiOperation(value = "用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer",name = "id",value = "id",required = false),
            @ApiImplicitParam(dataType = "String",name = "account",value = "账号",required = true),//required:是否必须
            @ApiImplicitParam(dataType = "String",name = "password",value = "密码",required = true),//required:是否必须
            @ApiImplicitParam(dataType = "String",name = "name",value = "姓名",required = false),
            @ApiImplicitParam(dataType = "String",name = "sex",value = "性别",required = false),
            @ApiImplicitParam(dataType = "String",name = "nation",value = "民族",required = false),
            @ApiImplicitParam(dataType = "Date",name = "dateOfBirth",value = "出生日期",required = false),
            @ApiImplicitParam(dataType = "String",name = "nativePlace",value = "籍贯",required = false),
            @ApiImplicitParam(dataType = "String",name = "address",value = "地址",required = false),
            @ApiImplicitParam(dataType = "String",name = "idCard",value = "身份证号码",required = false),
            @ApiImplicitParam(dataType = "String",name = "education",value = "学历",required = false),
            @ApiImplicitParam(dataType = "Date",name = "admissionTime",value = "入学时间",required = false),
            @ApiImplicitParam(dataType = "String",name = "applicationTime",value = "申请时间",required = false),
            @ApiImplicitParam(dataType = "String",name = "diploma",value = "积极分子结业证",required = false),
            @ApiImplicitParam(dataType = "String",name = "isAdult",value = "是否成年",required = false),
            @ApiImplicitParam(dataType = "Integer",name = "juri",value = "权限",required = false),
            @ApiImplicitParam(dataType = "Integer",name = "leaderStu",value = "党小组组长",required = false),
            @ApiImplicitParam(dataType = "Integer",name = "leaderTecher",value = "培养人_老师",required = false),
            @ApiImplicitParam(dataType = "String",name = "photo",value = "照片",required = false),
            @ApiImplicitParam(dataType = "String",name = "tel",value = "电话",required = false),
    })
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    @PostMapping
    public ResultVO regist(Activist activist){
        return new ResultVO(10002,"sec",null);
    }

}
