//package cn.edu.imau.interceptor;
//
//import cn.edu.imau.redpioneer.enums.ResStatus;
//import cn.edu.imau.redpioneer.enums.ResultVO;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.jsonwebtoken.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///**
// * @author: zyl
// * @date 2021/11/11 18:23
// */
//@Component
//public class CheckTokenInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //处理浏览器预检请求
//        String method = request.getMethod();
//        if("OPTIONS".equalsIgnoreCase(method)){
//            return true;
//        }
//        //通过请求头获取token
//        String token = request.getHeader("token");
//
//        if(token == null){
//            //请先登录
//            ResultVO resultVO = new ResultVO(ResStatus.LOGIN_FAIL_NOT.getValue()
//                    ,ResStatus.LOGIN_FAIL_NOT.getText(),null);
//            doResponse(response,resultVO);
//        }else{
//            try {
//                JwtParser parser = Jwts.parser();
//                parser.setSigningKey("ZYLpxrcsy666"); //解析token的SigningKey必须和生成token时设置密码一致
//
//                //如果token正确（密码正确,有效期内）则正常执行，否则抛出异常
//                Jws<Claims> claimsJws = parser.parseClaimsJws(token);
//                return true;
//
//            }catch (ExpiredJwtException e){
//                //登录过期
//                ResultVO resultVO = new ResultVO(ResStatus.LOGIN_EXPIRATION.getValue()
//                        ,ResStatus.LOGIN_EXPIRATION.getText(), null);
//                doResponse(response,resultVO);
//
//            }catch (UnsupportedJwtException e){
//                //token不合法
//                ResultVO resultVO = new ResultVO(ResStatus.TOKEN_ERROR.getValue()
//                        ,ResStatus.TOKEN_ERROR.getText(),null);
//                doResponse(response,resultVO);
//
//            }catch (Exception e){
//                //请先登录
//                ResultVO resultVO = new ResultVO(ResStatus.LOGIN_FAIL_NOT.getValue()
//                        ,ResStatus.LOGIN_FAIL_NOT.getText(), null);
//                doResponse(response,resultVO);
//            }
//        }
//        return false;
//    }
//
//    //未携带token时请求由拦截器利用response返回信息
//    private void doResponse(HttpServletResponse response,ResultVO resultVO) throws IOException {
//        response.setContentType("application/json");
//        response.setCharacterEncoding("utf-8");
//        PrintWriter out = response.getWriter();
//        String s = new ObjectMapper().writeValueAsString(resultVO);
//        out.print(s);
//        out.flush();
//        out.close();
//    }
//
//}
