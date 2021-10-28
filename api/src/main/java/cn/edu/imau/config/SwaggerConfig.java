package cn.edu.imau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: zyl
 * @date 2021/10/28 16:40
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

/** Swagger 会生成接口文档
 *  1.配置生成文档信息
 *  2.配置生成规则
 */
    @Bean
    public Docket getDocket(){
        //指定文档风格
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        //创建封面信息对象
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("《红色先锋后端接口说明》")
                .description("此文档说明了《红色先锋》项目的后端接口规范")
                .version("v 1.0.0")
                .contact(new Contact("zyl",null,"1156211195@qq.com"));

        ApiInfo apiInfo = apiInfoBuilder.build();

        //指定生成文档封面信息：文档标题，版本，作者
        docket.apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.edu.imau.controller"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }

}
