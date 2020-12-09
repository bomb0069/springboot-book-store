package com.example.bookstore;

import com.example.bookstore.book.Book;
import com.example.bookstore.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BookstoreApplication {

	@Autowired
	BookRepository bookRepository;

	@PostConstruct
	public void initialBookMasterData() {
		Book book1 = new Book("Harry Potter and the Philosopher's Stone",100,100);
		bookRepository.save(book1);
		Book book2 = new Book("Harry Potter and the Chamber of Secrets",100,100);
		bookRepository.save(book2);
		Book book3 = new Book("Harry Potter and the Prisoner of Azkaban",100,100);
		bookRepository.save(book3);
		Book book4 = new Book("Harry Potter and the Goblet of Fire",100,100);
		bookRepository.save(book4);
		Book book5 = new Book("Harry Potter and the Order of the Phoenix",100,100);
		bookRepository.save(book5);
	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
