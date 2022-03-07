package cn.edu.imau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@EnableScheduling//开启定时任务
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("cn.edu.imau.redpioneer.dao")
@ComponentScan(basePackages = "cn.edu.imau.*")
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ  \n");

    }
}
