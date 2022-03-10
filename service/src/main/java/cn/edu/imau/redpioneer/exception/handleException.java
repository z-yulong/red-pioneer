package cn.edu.imau.redpioneer.exception;

import cn.edu.imau.redpioneer.vo.Result;
import cn.edu.imau.redpioneer.vo.ResultVO;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

/**
 * @author: zyl
 * @date 2022/3/9 21:02
 */
public class handleException {
    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public ResultVO handle401(ShiroException e) {
        return new ResultVO(401, e.getMessage(), null);
    }

    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthenticatedException.class)
    public ResultVO handle401(UnauthenticatedException e) {
        return new ResultVO(401, "你没有权限访问", null);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = TokenExpiredException.class)
    public ResultVO handler(TokenExpiredException e) throws IOException {
        return new ResultVO(HttpStatus.BAD_REQUEST.value(),"token已经过期，请重新登录",null);
    }


}
