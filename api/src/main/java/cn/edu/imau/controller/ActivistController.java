package cn.edu.imau.controller;

import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.service.ActivistService;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

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

    /**
     * 用户登录
     * @param account
     * @param password
     */
    @ApiOperation(value = "用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "account",value = "用户名",required = true),
            @ApiImplicitParam(dataType = "String",name = "password",value = "密码",required = false,defaultValue = "888888")
    })
    @GetMapping("/login")
    public ResultVO login(@RequestParam("account")String account, @RequestParam(value = "password") String password) throws UnsupportedEncodingException {
        return activistService.login(account,password);
    }

    /**
     * 通过id删除一个用户
     * @param id
     * @return
     */

    @DeleteMapping("/delete/{id}")
    @ApiOperation("通过id删除一个用户")
    @RequiresRoles(logical = Logical.OR, value = {"管理员","党支部书记","党小组组长"})//拥有admin和shuji和zuzhuang角色的用户可以访问
    public ResultVO delete(@PathVariable("id") Integer id) {
        return activistService.deleteById(id);
    }

    /**
     * 通过id获取一个用户
     * @param id
     * @return
     */
    @GetMapping("getUser/{id}")
    @ApiOperation("通过id获取一个用户")
    @RequiresRoles(logical = Logical.OR, value = {"管理员","党支部书记","党小组组长"})
    public ResultVO getUserById(@PathVariable("id") Integer id) {
        return activistService.getUserById(id);
    }

    /**
     * 通过账号获取一个用户
     * @param account
     * @return
     */
    @GetMapping("getUserByAccount/{account}")
    @ApiOperation("通过账号获取一个用户")
    @RequiresRoles(logical = Logical.OR, value = {"管理员","党支部书记","党小组组长"})
    public ResultVO getUserByAccount(@PathVariable("account") String account) {
        return activistService.getUserByAccount(account);
    }

    /**
     * 通过账号获取一个用户
     * @param name
     * @return
     */
    @GetMapping("getUserByName/{name}")
    @ApiOperation("通过姓名获取一个用户")
    @RequiresRoles(logical = Logical.OR, value = {"管理员","党支部书记","党小组组长"})
    public ResultVO getUserByName(@PathVariable("name") String name) {
        return activistService.getUserByName(name);
    }

    /**
     * 通过id更新一个用户
     * @param activist
     * @return
     */
    @PutMapping("/updateById")
    @ApiOperation("通过id更新一个用户")
    @RequiresRoles(logical = Logical.OR, value = {"管理员","党支部书记","党小组组长"})
    public ResultVO update(@RequestBody Activist activist) {
        return activistService.updateActivistByid(activist);
    }


    /**
     * 通过角色查询支部负责人
     * @param
     * @return
     */
    @GetMapping("/getUserByRole")
    @ApiOperation("通过角色查询支部负责人")
    @RequiresRoles("管理员")
    public ResultVO getUserByRole() {
        return activistService.getUserByRole();
    }


    /**
     * 管理员注册账号
     * @param
     * @return
     */
    @GetMapping("/register")
    @ApiOperation("管理员注册账号")
    @RequiresRoles("管理员")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "account",value = "用户名",required = true),
            @ApiImplicitParam(dataType = "String",name = "name",value = "姓名",required = true),
            @ApiImplicitParam(dataType = "String",name = "roles",value = "角色",required = true,defaultValue = "user")})
    public ResultVO register(String account,String name,String roles) {
        return activistService.register(account,name,roles);
    }





}