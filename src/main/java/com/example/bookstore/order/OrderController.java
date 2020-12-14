package com.example.bookstore.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/orders")
    public PostOrderResponse postOrder(@Valid @RequestBody PostOrderRequest postOrderRequest) {
        OrderDetail orderDetail = orderService.orderBook(postOrderRequest.bookOrderList);
        return new PostOrderResponse(orderDetail.orderId, orderDetail.totalPrice);
    }

    @PostMapping("/orders/{orderId}/payment")
    public Map paymentToOrder(@PathVariable Long orderId, @Valid @RequestBody PaymentToOrderRequest paymentToOrderRequest) {
        PaymentDetail paymentDetail = new PaymentDetail(paymentToOrderRequest.cardNumber, paymentToOrderRequest.expiredDate, paymentToOrderRequest.cvv);
        orderService.paymentOrder(orderId, paymentDetail);
        return Collections.singletonMap("message", "your order is successed");
    }
}
