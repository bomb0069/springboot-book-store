package com.example.bookstore.order;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostOrderResponse {
    @JsonProperty("order_id")
    Long orderId;
    @JsonProperty("total_price")
    double totalPrice;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
