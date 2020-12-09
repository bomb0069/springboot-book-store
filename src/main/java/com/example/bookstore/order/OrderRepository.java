package com.example.bookstore.order;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository <UserOrder, Integer> {
}
