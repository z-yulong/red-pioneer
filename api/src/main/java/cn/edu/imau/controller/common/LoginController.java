package cn.edu.imau.controller.common;

import cn.edu.imau.redpioneer.service.commonservice.LoginService;
import cn.edu.imau.redpioneer.utils.VerifyUtil;
import cn.edu.imau.redpioneer.vo.ResultVO;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author: zyl
 * @date 2022/3/10 15:29
 */
@CrossOrigin//解决跨域访问
@RestController
@RequestMapping("/login")
@Api(value = "提供用户登录注册接口",tags = "用户管理")
public class LoginController {
    @Resource
    LoginService loginService;

    /**
     * 用户登录
     * @param account
     * @param password
     */
//    @ApiOperation(value = "用户登录接口")
//    @PostMapping("/tologin")
//    public ResultVO login(@RequestParam("account")String account,
//                          @RequestParam(value = "password") String password,
//                          @RequestParam(value = "validateCode") String validateCode ) throws UnsupportedEncodingException {
//        return loginService.login(account,password,validateCode);
//    }
    @ApiOperation(value = "用户登录接口")
    @PostMapping("/tologin")
    public ResultVO login(@RequestParam("account")String account,
                          @RequestParam(value = "password") String password) throws UnsupportedEncodingException {
        return loginService.login(account,password);
    }

    @GetMapping("/getVerifyCode")
    public void getVerifyCode(HttpServletResponse response) throws IOException {
        // 生成默认的验证码图片
        Object[] obj = VerifyUtil.newBuilder().build().createImage();
        // obj[0]是验证码的字符串，放入session
        Subject subject = SecurityUtils.getSubject();
        //判断验证码
        Session s =subject.getSession();

        s.setAttribute("verifyCode", obj[0]);
        // obj[1]是验证码图片
        BufferedImage image = (BufferedImage) obj[1];
        OutputStream outputStream = response.getOutputStream();
        // 设置响应类型
        response.setContentType("image/png");
        // IO输出图片
        ImageIO.write(image, "png", outputStream);

    }


}
