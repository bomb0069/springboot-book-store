package com.example.bookstore.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public List<BookResponse> getAllBooks() {
        Iterable<Book> bookTable = bookRepository.findAll();
        List<BookResponse> listBookResponse = new ArrayList<>();
        for (Book book : bookTable) {
            BookResponse bookResponse = new BookResponse();
            bookResponse.setId(book.id);
            bookResponse.setTitle(book.title);
            bookResponse.setPrice(book.price);
            bookResponse.setStock(book.stock);
            listBookResponse.add(bookResponse);
        }
        return listBookResponse;
    }
}
