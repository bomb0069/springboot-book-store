package com.example.bookstore.gateway;

import com.example.bookstore.order.PaymentDetail;

public class RequestPayment {
    double transactionAmount;
    PaymentDetail paymentDetail;

    public RequestPayment(double transactionAmount, PaymentDetail paymentDetail) {
        this.transactionAmount = transactionAmount;
        this.paymentDetail = paymentDetail;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public PaymentDetail getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(PaymentDetail paymentDetail) {
        this.paymentDetail = paymentDetail;
    }
}
