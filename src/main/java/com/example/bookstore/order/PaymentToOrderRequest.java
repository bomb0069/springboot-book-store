package com.example.bookstore.order;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.YearMonth;

public class PaymentToOrderRequest {
    @NotNull @Size(min = 16 , max = 16)
    String cardNumber;
    @NotNull @Future
    YearMonth expiredDate;
    @NotNull @Size(min = 3 , max = 3)
    String cvv;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public YearMonth getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(YearMonth expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
