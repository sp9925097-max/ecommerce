package com.ecommerce.backend1.controller;

import com.ecommerce.backend1.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/mail")
public class MailController {

    private final EmailService emailService;

    public MailController(EmailService emailService){
        this.emailService = emailService;
    }
    public ResponseEntity<String> sendMail(){
        emailService.sendEmail("sp9925097@gmail.com","Order Placed", "Your order is confirmed");
        return ResponseEntity.ok("Email sent");
    }
}
