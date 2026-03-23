package com.ecommerce.backend1.controller;

import com.ecommerce.backend1.entity.Order;
import com.ecommerce.backend1.repository.OrderRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final OrderRepository orderRepository;

    public PaymentController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping("/pay")
    public String makePayment(){
        return "Payment Successful";
    }
    @PostMapping("/pay/{orderId}")
    public String pay(@PathVariable Long orderId){
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus("PAID");
        orderRepository.save(order);
        return "Payment Successful";
    }
}
