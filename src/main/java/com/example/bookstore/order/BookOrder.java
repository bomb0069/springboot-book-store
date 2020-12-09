package com.example.bookstore.order;

import com.fasterxml.jackson.annotation.JsonProperty;

class BookOrder {
    @JsonProperty("book_id")
    Integer bookId;
    Integer quantity;

    public BookOrder(Integer bookId, Integer quantity) {
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
