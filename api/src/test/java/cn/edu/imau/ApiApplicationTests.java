package cn.edu.imau;

import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.entity.Activist;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
class ApiApplicationTests {

    @Resource
    private ActivistMapper activistMapper;

    @Test
    void contextLoads() {

        Activist activist = new Activist();
        activist.setId(2);
        activist.setPassword("222");
        activistMapper.updateInfoByPrimaryKey(activist);

    }


}
