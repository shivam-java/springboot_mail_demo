package com.springboot_mail_demo.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private  JavaMailSender javaMailSender;

    @Value("${host.value}")
  private   String host;
    @Value("${port.value}")
    private String port;

    @Value("${mail.username}")
    private String username;

    @Value("${mail.password}")
    private String password;


    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(Integer.parseInt(port));
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        mailSender.setProtocol("smtp");
        mailSender.getJavaMailProperties().put("mail.smtp.starttls.enable", "true");
        mailSender.getJavaMailProperties().put("mail.smtp.auth", "true");
        javaMailSender = mailSender;
        return javaMailSender;
    }

    public void sendEmail(String toEmail, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(username);
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        getJavaMailSender();
        javaMailSender.send(mailMessage);
    }
}
