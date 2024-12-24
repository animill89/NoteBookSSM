package edu.cqie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class EmailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody Map<String, String> requestBody, HttpSession session) {
        String email = requestBody.get("email");
        System.out.print(email);
        try {
            // 生成六位数验证码
            String captcha = String.valueOf((int) (Math.random() * 900000) + 100000);
            session.getServletContext().setAttribute("captcha", captcha); // 存储验证码
            String code = String.valueOf(session.getAttribute("captcha"));
            String id = String.valueOf(session.getId());
            System.out.println(id);
            // 创建邮件消息
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("1195694857@qq.com");
            message.setTo(email);
            message.setSubject("您的验证码");
            message.setText("您的验证码是: " + captcha + "，请在5分钟内使用。");

            javaMailSender.send(message);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return "邮件发送失败，请重试。";
        }
    }
}