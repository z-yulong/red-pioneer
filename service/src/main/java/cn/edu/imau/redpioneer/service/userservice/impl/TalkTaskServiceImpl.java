package cn.edu.imau.redpioneer.service.userservice.impl;

import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.entity.DevelopmentInfo;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.enums.State;
import cn.edu.imau.redpioneer.service.userservice.TalkTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.lang.model.element.VariableElement;
import java.util.Date;
import java.util.List;

/**
 * @author: zyl
 * @date 2022/1/18 9:58
 */
@Service
@Component
public class TalkTaskServiceImpl implements TalkTaskService {

    @Autowired
    private ActivistMapper activistMapper;
    @Resource
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    //@Scheduled(fixedDelay = 7900000000L)
    @Scheduled(fixedDelay = 1000)
    @Override
    public ResultVO partyGroupTalk() {
        System.out.println("一秒>>>>>>>"+new Date());
        return null;
    }

    //@Scheduled(fixedDelay = 7900000000L)
    @Scheduled(fixedDelay = 2000)
    @Override
    public ResultVO partyBrabchTalk() {
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        //创建一个Example封装类 类别Activist查询条件
//        Example example = new Example(Activist.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("id", 1);
//
//        Activist activist = activistMapper.selectOneByExample(example);
//
//        message.setFrom(from);// 发送人邮箱
//        message.setTo(activist.getEmail()); //目标邮箱
//        message.setSubject("subject"); //邮件主题
//        message.setText("您的谈话时间即将结束，请尽快上传谈话记录"); //邮件内容
//
//        javaMailSender.send(message);

        return null;
    }


}
