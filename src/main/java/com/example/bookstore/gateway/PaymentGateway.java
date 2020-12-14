package com.example.bookstore.gateway;

import com.example.bookstore.order.PaymentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class PaymentGateway {

    private final RestTemplate restTemplate;
    private final String paymentAPIUrl;

    @Autowired
    public PaymentGateway(final RestTemplate restTemplate,
                          @Value("${payment.api.url}") final String postApiUrl) {
        this.restTemplate = restTemplate;
        this.paymentAPIUrl = postApiUrl;
    }

    public boolean createOrderTransaction(double totalPrice, PaymentDetail paymentDetail) {
        RequestPayment requestPayment = new RequestPayment(totalPrice, paymentDetail);
        ResponseEntity<Map> response = restTemplate.postForEntity(paymentAPIUrl, requestPayment, Map.class);
        if (response.getStatusCode().is2xxSuccessful() && response.getBody().get("status").equals("OK")) {
            return true;
        }
        return false;
    }
}