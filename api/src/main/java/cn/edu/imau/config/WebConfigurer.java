package cn.edu.imau.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: zyl
 * @date 2022/3/12 10:22
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Value("${spring.mvc.static-path-pattern}")
    private String staticAccessPath;
    @Value("${spring.resources.static-locations}")
    private String uploadFolder;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticAccessPath).addResourceLocations(uploadFolder);

    }
}
