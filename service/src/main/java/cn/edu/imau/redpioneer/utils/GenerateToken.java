package cn.edu.imau.redpioneer.utils;

import cn.edu.imau.redpioneer.entity.Activist;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;

/**
 * @author: zyl
 * @date 2021/11/21 10:32
 */
public class GenerateToken {

    public static String createToken(Integer id, String account, Activist activist, HashMap<String,Object> map){

        JwtBuilder builder = Jwts.builder();
        String token = builder.setSubject(account)          //主题，就是token中携带的数据
                .setIssuedAt(new Date())                    //设置token的生成时间
                .setId(activist.getId() + "")               //设置用户id为token  id
                .setClaims(map)                             //map中可以存放用户的角色权限信息
                .setExpiration(new Date(System.currentTimeMillis() + 24*60*60*1000)) //设置token过期时间(当前为1天)
                .signWith(SignatureAlgorithm.HS256, "ZYLpxrcsy666")//设置加密方式和加密密码
                .compact();
        return token;
    }

    public static String createToken(Integer id, String account, Activist activist){
        JwtBuilder builder = Jwts.builder();
        String token = builder.setSubject(account)          //主题，就是token中携带的数据
                .setIssuedAt(new Date())                    //设置token的生成时间
                .setId(activist.getId() + "")               //设置用户id为token  id
                //.setClaims(map)                             //map中可以存放用户的角色权限信息
                .setExpiration(new Date(System.currentTimeMillis() + 24*60*60*1000)) //设置token过期时间(当前为1天)
                .signWith(SignatureAlgorithm.HS256, "ZYLpxrcsy666")//设置加密方式和加密密码
                .compact();
        return token;
    }
}
