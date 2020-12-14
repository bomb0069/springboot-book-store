package com.example.bookstore.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedBookRepository extends CrudRepository<OrderedBook, Long> {
}
