package cn.edu.imau.controller;

import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.enums.ResultVO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * 无权限跳转到此接口
 * @author: zyl
 * @date 2021/12/8 12:20
 */


@CrossOrigin//解决跨域访问
@RestController
@RequestMapping("/user")
@Api(value = "未经授权",tags = "未经授权")
public class Unauthorized {

    @RequestMapping(path = "/unauthorized/{message}")
    public ResultVO unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        return new ResultVO(ResStatus.USER_UNAUTHORIZED.getValue(), ResStatus.USER_UNAUTHORIZED.getText(), null);
    }
}
