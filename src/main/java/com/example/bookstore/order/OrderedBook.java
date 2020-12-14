package com.example.bookstore.order;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class OrderedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Integer bookId;
    Integer quantity;

    @ManyToOne
    @JoinColumn (name = "userOrder")
    @NotNull
    UserOrder userOrder;

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

    public UserOrder getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(UserOrder userOrder) {
        this.userOrder = userOrder;
    }
}
