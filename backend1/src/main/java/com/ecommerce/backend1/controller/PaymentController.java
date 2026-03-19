package com.ecommerce.backend1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @PostMapping("/pay")
    public String makePayment(){
        return "Payment Successful";
    }
}
