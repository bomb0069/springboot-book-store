package com.example.bookstore.order;

import java.time.YearMonth;

public class PaymentDetail {
    String cardNumber;
    String expiredDate;
    String cvv;

    public PaymentDetail(String cardNumber, YearMonth expiredDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiredDate = expiredDate.toString();
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
