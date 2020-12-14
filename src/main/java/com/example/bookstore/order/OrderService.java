package com.example.bookstore.order;

import com.example.bookstore.book.Book;
import com.example.bookstore.book.BookRepository;
import com.example.bookstore.gateway.PaymentGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserOrderRepository userOrderRepository;

    @Autowired
    OrderedBookRepository orderedBookRepository;

    @Autowired
    PaymentGateway paymentGateway;

    private static final Map<Long, Book> bookDocument = new HashMap<>();

    @Autowired
    public void init() {
        Iterable<Book> books = bookRepository.findAll();
        books.forEach(book -> bookDocument.put(book.getId(), book));
    }

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
        for (OrderedBook orderedBook : userOrder.orderedBookList) {
            orderedBook.setUserOrder(userOrder);
        }
        orderedBookRepository.saveAll(userOrder.orderedBookList);
        return new OrderDetail(userOrder.id, userOrder.totalPrice);
    }

    private double calculateTotalPrice(List<BookOrder> bookOrderList) {
        double totalPrice = 0;
        for (BookOrder bookOrder : bookOrderList) {
            totalPrice += bookDocument.get(bookOrder.bookId.longValue()).getPrice() * bookOrder.quantity;
        }

        // 1 diff x1
        // 2 diff x0.9
        // 3 diff x0.95
        // 4 diff x0.8
        // 5 diff x0.75
        return totalPrice;
    }

    @Transactional
    public void paymentOrder(Long orderId, PaymentDetail paymentDetail) {
        Optional<UserOrder> userOrder = userOrderRepository.findById(orderId);
        if (userOrder.isPresent()) {
            boolean paymentStatus = paymentGateway.createOrderTransaction(userOrder.get().totalPrice, paymentDetail);
            if (paymentStatus == true) {
                userOrder.get().setDone(true);
                userOrderRepository.save(userOrder.get());

                for (OrderedBook orderedBook : userOrder.get().orderedBookList) {
                    bookRepository.removeFromStock(orderedBook.bookId, orderedBook.quantity);
                }
                return;
            }
            throw new RuntimeException("OrderService : paymentOrder Error");
        }
        throw new RuntimeException("OrderService : your order is invalid");
    }
}
