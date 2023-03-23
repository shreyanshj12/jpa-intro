package com.sj.jpaintro;

import static org.assertj.core.api.Assertions.assertThat;

import com.sj.jpaintro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaIntroApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testBookRepository() {
		long count = bookRepository.count();
		assertThat(count).isGreaterThan(0);
	}
}
