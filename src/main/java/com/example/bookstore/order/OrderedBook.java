package com.example.bookstore.order;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderedBook {
    @Id
    Long id;
    Integer bookId;
    Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
