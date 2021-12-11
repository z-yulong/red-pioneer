//package cn.edu.imau.redpioneer.resolver;
//
//import cn.edu.imau.redpioneer.entity.Activist;
//import cn.edu.imau.redpioneer.service.ActivistService;
//import cn.edu.imau.redpioneer.annotation.CurrentUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.MethodParameter;
//import org.springframework.web.bind.support.WebDataBinderFactory;
//import org.springframework.web.context.request.NativeWebRequest;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.method.support.ModelAndViewContainer;
//
///**
// * @author: zyl
// * @date 2021/11/26 19:43
// */
//public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
//    @Autowired
//    private ActivistService activistService;
//
//    @Override
//    public boolean supportsParameter(MethodParameter methodParameter) {
//        return methodParameter.hasParameterAnnotation(CurrentUser.class) && Activist.class.isAssignableFrom(methodParameter.getParameterType());
//
//    }
//
//    @Override
//    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
//        //return activistService.getCurrent();
//        return null;
//    }
//}
