package com.example.bookstore.order;

import com.example.bookstore.gateway.PaymentGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    UserOrderRepository userOrderRepository;

    @Autowired
    OrderedBookRepository orderedBookRepository;

    @Autowired
    PaymentGateway paymentGateway;

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
        UserOrder userOrder = new UserOrder(totalPrice, orderedBookList);
        userOrderRepository.save(userOrder);
        Iterator<OrderedBook> iterator = userOrder.orderedBookList.iterator();
        while (iterator.hasNext()) {
            iterator.next().setUserOrder(userOrder);
        }
        orderedBookRepository.saveAll(userOrder.orderedBookList);
        return new OrderDetail(userOrder.id, userOrder.totalPrice);
    }

    private double calculateTotalPrice(List<BookOrder> bookOrderList) {
        // 1 diff x1

        // 2 diff x0.9

        // 3 diff x0.95

        // 4 diff x0.8

        // 5 diff x0.75
        return 375;
    }

    public void paymentOrder(Long orderId, PaymentDetail paymentDetail) {
        Optional<UserOrder> userOrder = userOrderRepository.findById(orderId);
        if (userOrder.isPresent()) {
            boolean paymentStatus = paymentGateway.createOrderTransaction(userOrder.get().totalPrice,paymentDetail);
            if (paymentStatus == true) {
                userOrder.get().setDone(true);
                userOrderRepository.save(userOrder.get());
                return;
            }
            throw new RuntimeException("OrderService : paymentOrder Error");
        }
    }
}
