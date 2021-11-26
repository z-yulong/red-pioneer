package cn.edu.imau;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("cn.edu.imau.redpioneer.dao")
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);

        System.out.println(
                        "                        _ooOoo_\n" +
                        "                       o8888888o\n" +
                        "                       88\" . \"88\n" +
                        "                       (| -_- |)\n" +
                        "                       O\\  =  /O\n" +
                        "                    ____/`---'\\____\n" +
                        "                  .'  \\\\|     |//  `.\n" +
                        "                 /  \\\\|||  :  |||//  \\\n" +
                        "                /  _||||| -:- |||||_  \\\n" +
                        "                |   | \\\\\\  -  /'| |   |\n" +
                        "                | \\_|  `\\`---'//  |_/ |\n" +
                        "                \\  .-\\__ `-. -'__/-.  /\n" +
                        "              ___`. .'  /--.--\\  `. .'___\n" +
                        "           .\"\" '<  `.___\\_<|>_/___.' _> \\\"\".\n" +
                        "          | | :  `- \\`. ;`. _/; .'/ /  .' ; |\n" +
                        "          \\  \\ `-.   \\_\\_`. _.'_/_/  -' _.' /\n" +
                        "============-.`___`-.__\\ \\___  /__.-'_.'_.-'============\n" +
                        "                          `=--=-'  \n" +""
        );
        System.out.println("(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ  \n");

    }

}
