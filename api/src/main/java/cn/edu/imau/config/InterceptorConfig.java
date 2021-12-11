//package cn.edu.imau.config;
//
//import cn.edu.imau.interceptor.CheckTokenInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * @author: zyl
// * @date 2021/11/11 18:33
// */
//@Configuration
//public class InterceptorConfig implements WebMvcConfigurer {
//
//    @Autowired
//    private CheckTokenInterceptor checkTokenInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(checkTokenInterceptor)
//                //拦截
//                .addPathPatterns("/center/**")
//                .addPathPatterns("/import/**")
//                .addPathPatterns("/user/**")
//                //不拦截
//                .excludePathPatterns("/user/login");
//    }
//}
