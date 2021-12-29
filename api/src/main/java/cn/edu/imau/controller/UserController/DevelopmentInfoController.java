package cn.edu.imau.controller.UserController;

import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.service.userservice.DevelopmentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.IOException;

/**
 * @author: zyl
 * @date 2021/12/30 13:25
 */
@CrossOrigin
@RestController
@RequestMapping("/development")
@Api(value = "提供普通用户发展信息操作接口",tags = "发展信息")
public class DevelopmentInfoController {

    @Autowired
    DevelopmentInfoService developmentInfoService;

    @RequiresRoles("user")
    @ApiOperation(value = "获取用户惩信息接口")
    @GetMapping("/uploadRdsq")
    public ResultVO uploadRdsq(MultipartFile imgFile,ServletRequest request) throws IOException {
        return developmentInfoService.uploadRdsq(imgFile,request);
    }

}
