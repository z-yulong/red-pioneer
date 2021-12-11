package cn.edu.imau.redpioneer.annotation;

import java.lang.annotation.*;

/**
 * 当前登录用户信息注解
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser{

}