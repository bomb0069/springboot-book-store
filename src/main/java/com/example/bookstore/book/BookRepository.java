package com.example.bookstore.book;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Modifying
    @Query(value = "UPDATE book SET stock = stock - :quantity WHERE id = :id", nativeQuery = true)
    void removeFromStock(@Param("id") Long id, @Param("quantity") Integer quantity);

}
