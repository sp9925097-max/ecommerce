package com.ecommerce.backend1.controller;

import com.ecommerce.backend1.dto.ApiResponse;
import com.ecommerce.backend1.entity.Cart;
import com.ecommerce.backend1.entity.Order;
import com.ecommerce.backend1.entity.OrderItem;
import com.ecommerce.backend1.repository.CartRepository;
import com.ecommerce.backend1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/place/{userId}")
    public Order placeOrder(@PathVariable Long userId){

        List<Cart> cartItems = cartRepository.findByUserId(userId);
        if(cartItems.isEmpty()){
            throw new RuntimeException("Cart is empty");
        }
        double total = cartItems.stream()
                .mapToDouble(c -> c.getProduct().getPrice())
                .sum();
        Order order = new Order();
        order.setUser(cartItems.get(0).getUser());
        order.setTotalAmount(total);
        order.setStatus("PLACED");




         orderRepository.save(order);
        cartRepository.deleteAll(cartItems);
        return order;
    }
    @GetMapping("/user/{userId}")
    public List<Order> getOrders(@PathVariable Long userId){
        return orderRepository.findByUserId(userId);
    }
    @PutMapping("/{id}/status")
    public Order updateStatus(@PathVariable Long id,
                              @RequestParam String status){
        Order order = orderRepository.findById(id).orElseThrow();
        order.setStatus(status);
        return orderRepository.save(order);
    }
    @GetMapping("/my-orders")
    public List<Order> getMyOrders(Authentication auth){
        String email = auth.getName();
        return orderRepository.findByUserEmail(email);
    }
    @GetMapping("/{id}/status")
    public String getStatus(@PathVariable Long id){
        return orderRepository.findById(id).get().getStatus();
    }
    @GetMapping("/count")
    public long getOrderCount(){
        return orderRepository.count();
    }
    public ResponseEntity<ApiResponse<String>> generateInvoice(@PathVariable Long orderId){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        StringBuilder invoice = new StringBuilder();
        invoice.append("Invoice for Order ID: ").append(orderId).append("\n");

        for(OrderItem item : order.getOrderItems()){
            invoice.append("Product: ")
                    .append(item.getProduct().getName())
                    .append(" | Price: ")
                    .append(item.getProduct().getPrice())
                    .append(" | Quantity: ")
                    .append(item.getQuantity())
                    .append("\n");
        }
        invoice.append("Total amount: ").append(order.getTotalAmount());

        return ResponseEntity.ok(
                new ApiResponse<>("Invoice generated", invoice.toString())
        );
    }
}

