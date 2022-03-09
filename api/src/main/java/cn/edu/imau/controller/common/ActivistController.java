package cn.edu.imau.controller.common;

import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.service.commonservice.ActivistService;
import io.swagger.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @author: zyl
 * @date 2021/10/28 17:08
 */
@CrossOrigin//解决跨域访问
@RestController
@RequestMapping("/activist")
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
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang"})//拥有admin和shuji和zuzhuang角色的用户可以访问
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
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang"})
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
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang"})
    public ResultVO getUserByAccount(@PathVariable("account") String account) {
        return activistService.getUserByAccount(account);
    }

    /**
     * 通过姓名获取一个用户
     * @param name
     * @return
     */
    @GetMapping("getUserByName/{name}")
    @ApiOperation("通过姓名获取一个用户")
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang"})
    public ResultVO getUserByName(@PathVariable("name") String name) {
        return activistService.getUserByName(name);
    }

    /**
     * 通过id更新个人信息
     * @param activist
     * @return
     */
    @PutMapping("/updateById")
    @ApiOperation("通过id更新个人信息")
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    public ResultVO update(@RequestBody Activist activist, HttpServletRequest request) {
        return activistService.updateActivistByid(activist,request);
    }


    /**
     * 管理员注册账号
     * @param
     * @return
     */
    @GetMapping("/register")
    @ApiOperation("管理员注册账号")
    @RequiresRoles("admin")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "account",value = "用户名",required = true),
            @ApiImplicitParam(dataType = "String",name = "name",value = "姓名",required = true),
            @ApiImplicitParam(dataType = "String",name = "roles",value = "角色",required = true,defaultValue = "user")})
    public ResultVO register(String account,String name,String roles) {
        return activistService.register(account,name,roles);
    }


    /**
     * 分页查询所有人
     * @param rowBounds
     * @param request
     * @return
     */
    @PostMapping("/getActivistPage")
    @ApiOperation("分页查询所有人")
    @RequiresRoles("admin")
    public ResultVO getActivistPage(@RequestBody RowBounds rowBounds, HttpServletRequest request){
        return activistService.selectActivistPage(rowBounds,request);
    }
}
