package cn.edu.imau.redpioneer.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


/**
 * @author: zyl
 * @date 2022/1/19 20:44
 */
@Component
public class MessageUtil {
    @Value("${spring.mail.username}")
    private String email;
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMessage(String toEmail,String Subject,String text){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(email);// 发送人邮箱
        message.setTo(toEmail); //目标邮箱
        message.setSubject(Subject); //邮件主题
        message.setText(text); //邮件内容
        message.setBcc();
        //发送邮件
        javaMailSender.send(message);
    }


}
