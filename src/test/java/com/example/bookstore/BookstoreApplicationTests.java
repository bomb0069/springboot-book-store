package com.example.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("PMD")
@SpringBootTest
@ActiveProfiles("test")
class BookstoreApplicationTests {

	@Test
	void contextLoads() {
		assertTrue(true);
	}

}
