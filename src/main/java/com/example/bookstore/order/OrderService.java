package com.example.bookstore.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderedBookRepository orderedBookRepository;

    @Transactional
    public OrderDetail orderBook(List<BookOrder> bookOrderList) {
        double totalPrice = calculateTotalPrice(bookOrderList);
        List<OrderedBook> orderedBookList = new ArrayList<>();
        for (BookOrder bookOrder : bookOrderList) {
            OrderedBook orderedBook = new OrderedBook();
            orderedBook.setBookId(bookOrder.bookId);
            orderedBook.setQuantity(bookOrder.quantity);
            orderedBookList.add(orderedBook);
        }
        UserOrder userOrder = new UserOrder(totalPrice,orderedBookList);
        orderRepository.save(userOrder);

        Iterator<OrderedBook> iterator = userOrder.orderedBookList.iterator();
        while (iterator.hasNext()){
            iterator.next().setUserOrder(userOrder);
        }
        orderedBookRepository.saveAll(userOrder.orderedBookList);
        return new OrderDetail(userOrder.id,userOrder.totalPrice);
    }

    private double calculateTotalPrice(List<BookOrder> bookOrderList) {
        // 1 diff x1

        // 2 diff x0.9

        // 3 diff x0.95

        // 4 diff x0.8

        // 5 diff x0.75
        return 375;
    }

}
