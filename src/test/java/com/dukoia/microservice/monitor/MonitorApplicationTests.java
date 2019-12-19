package com.dukoia.microservice.monitor;

import com.alibaba.fastjson.JSON;
import com.dukoia.microservice.monitor.bean.MailBean;
import com.dukoia.microservice.monitor.bean.Student;
import com.dukoia.microservice.monitor.response.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MonitorApplicationTests {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private JavaMailSender javaMailSender;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private String REDIS_KEY = "MONITOR";
    @Test
    public void contextLoads() {

        Boolean hasKey = redisTemplate.hasKey("REDIS_KEY");
        if (!hasKey){

            redisTemplate.opsForValue().set(REDIS_KEY,"200");
        }
        String value = redisTemplate.opsForValue().get(REDIS_KEY);
        System.out.println(value);
        if (!"300".equals(value)){
            System.out.println("获取的值不一样");
        }
        redisTemplate.delete(REDIS_KEY);
        System.out.println(redisTemplate.hasKey("REDIS_KEY"));
//        Result<Student> result = restTemplate.getForObject("http://106.13.196.27:8880/hello/1", Result.class);
//        System.out.println(JSON.toJSONString(result));
//        MailBean mailBean = new MailBean();
//        mailBean.setContent("这是一个缠绵悱恻的故事");
//        mailBean.setRecipient("dukoia@sina.com");
//        mailBean.setSubject("监控服务");
//
//        sendSimpleMail(mailBean);
    }


//    public void sendSimpleMail(MailBean mailBean) {
//        try {
//            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//            //邮件发送人
//            simpleMailMessage.setFrom("1051246021@qq.com");
//            //邮件接收人
//            simpleMailMessage.setTo(mailBean.getRecipient());
//            //邮件主题
//            simpleMailMessage.setSubject(mailBean.getSubject());
//            //邮件内容
//            simpleMailMessage.setText(mailBean.getContent());
//            javaMailSender.send(simpleMailMessage);
//        } catch (Exception e) {
////            log.error("邮件发送失败", e);
//        }
//    }

}
