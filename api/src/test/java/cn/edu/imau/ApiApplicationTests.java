package cn.edu.imau;

import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.dao.DevelopmentInfoMapper;
import cn.edu.imau.redpioneer.entity.ActivistConversation;
import cn.edu.imau.redpioneer.entity.ActivistDevelopmentInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@SpringBootTest
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
class ApiApplicationTests {

    @Resource
    private ActivistMapper activistMapper;

    @Autowired
    DevelopmentInfoMapper developmentInfoMapper;
    @Test
    void contextLoads() {


    }


}
