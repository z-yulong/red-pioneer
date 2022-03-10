package cn.edu.imau.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 封装token来替换Shiro原生Token
 */
public class JWTToken implements AuthenticationToken {

    private String token;

    public JWTToken(String token){
        this.token=token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
