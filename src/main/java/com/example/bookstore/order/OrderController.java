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
        PostOrderResponse postOrderResponse = new PostOrderResponse();
        OrderDetail orderDetail = orderService.orderBook(postOrderRequest.bookOrderList);
        postOrderResponse.setOrderId(orderDetail.orderId);
        postOrderResponse.setTotalPrice(orderDetail.totalPrice);
        return postOrderResponse;
    }
}
