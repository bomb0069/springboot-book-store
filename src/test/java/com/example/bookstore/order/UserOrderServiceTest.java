package com.example.bookstore.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserOrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    void orderBook() {
        List<BookOrder> bookOrderList = new ArrayList<>();
        BookOrder bookOrder1 = new BookOrder((long) 1,1);
        bookOrderList.add(bookOrder1);
        BookOrder bookOrder2 = new BookOrder((long) 2,1);
        bookOrderList.add(bookOrder2);
        BookOrder bookOrder3 = new BookOrder((long) 3,1);
        bookOrderList.add(bookOrder3);
        BookOrder bookOrder4 = new BookOrder((long) 4,1);
        bookOrderList.add(bookOrder4);
        BookOrder bookOrder5 = new BookOrder((long) 5,1);
        bookOrderList.add(bookOrder5);

        OrderDetail actualResult = orderService.orderBook(bookOrderList);

        assertEquals(500,actualResult.totalPrice);
        assertNotNull(actualResult.orderId);
    }
}