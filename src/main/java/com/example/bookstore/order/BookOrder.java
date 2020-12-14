package com.example.bookstore.order;

import com.fasterxml.jackson.annotation.JsonProperty;

class BookOrder {
    @JsonProperty("book_id")
    Long bookId;
    Integer quantity;

    public BookOrder(Long bookId, Integer quantity) {
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
