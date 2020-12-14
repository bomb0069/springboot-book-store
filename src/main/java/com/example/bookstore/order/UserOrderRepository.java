package com.example.bookstore.order;

import org.springframework.data.repository.CrudRepository;

public interface UserOrderRepository extends CrudRepository <UserOrder, Long> {
}
