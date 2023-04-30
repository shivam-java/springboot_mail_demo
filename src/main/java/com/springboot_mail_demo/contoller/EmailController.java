package com.springboot_mail_demo.contoller;

import com.springboot_mail_demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

   @Autowired
    private EmailService emailService;
    @GetMapping("/send")
    public String emailService()
    {
        String msg="mail sent";
        try {
            emailService.sendEmail("shivam_test_au@outlook.com","Test Spring Boot Mail","Hello");

        }
        catch (Exception exception)
        {
            msg=exception.getMessage();
        }
       return msg;
    }
}
