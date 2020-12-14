package com.example.bookstore.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/orders")
    public PostOrderResponse postOrder(@Valid @RequestBody PostOrderRequest postOrderRequest) {
        OrderDetail orderDetail = orderService.orderBook(postOrderRequest.bookOrderList);
        return new PostOrderResponse(orderDetail.orderId, orderDetail.totalPrice);
    }

}
