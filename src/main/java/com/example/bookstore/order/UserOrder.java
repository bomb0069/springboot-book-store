package com.example.bookstore.order;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    double totalPrice;
    boolean isDone;

    @OneToMany(mappedBy = "userOrder")
    List<OrderedBook> orderedBookList;

    public UserOrder() {
    }

    public UserOrder(double totalPrice, List<OrderedBook> orderedBookList) {
        this.totalPrice = totalPrice;
        this.orderedBookList = orderedBookList;
        this.isDone = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public List<OrderedBook> getOrderedBookListList() {
        return orderedBookList;
    }

    public void setOrderedBookListList(List<OrderedBook> orderedBookList) {
        this.orderedBookList = orderedBookList;
    }


}
