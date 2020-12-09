package com.example.bookstore.order;

import java.util.List;

public class PostOrderRequest {
    List<BookOrder> bookOrderList;

    public List<BookOrder> getBookOrderList() {
        return bookOrderList;
    }

    public void setBookOrderList(List<BookOrder> bookOrderList) {
        this.bookOrderList = bookOrderList;
    }

}
