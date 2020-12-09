package com.example.bookstore.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public OrderDetail orderBook(List<BookOrder> bookOrderList) {
        double totalPrice = calculateTotalPrice(bookOrderList);
        List<OrderedBook> orderedBookList = new ArrayList<>();
        for (BookOrder bookOrder : bookOrderList) {
            OrderedBook orderedBook = new OrderedBook();
            orderedBook.setBookId(bookOrder.bookId);
            orderedBook.setQuantity(bookOrder.quantity);
            orderedBookList.add(orderedBook);
        }
        UserOrder order = new UserOrder(totalPrice,orderedBookList);
        orderRepository.save(order);

        return new OrderDetail(order.id,order.totalPrice);
    }

    private double calculateTotalPrice(List<BookOrder> bookOrderList) {
        return 375;
    }

}
