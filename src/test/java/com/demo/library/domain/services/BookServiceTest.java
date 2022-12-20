package com.demo.library.domain.services;

import com.demo.library.domain.exceptions.Issue;
import com.demo.library.domain.exceptions.ResourceNotFoundException;
import com.demo.library.domain.exceptions.Severity;
import com.demo.library.domain.models.Book;
import com.demo.library.domain.repositories.BookRepository;
import com.demo.library.domain.services.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	@Mock
	BookRepository bookRepository;

	@InjectMocks
	BookServiceImpl bookService;

	@Test
	public void whenSaveABookShouldReturnABook() {
		Book newBook = Book.builder()
				.tile("Sample")
				.description("Description...")
				.numberOfPages(10)
				.publishedAt(Instant.now())
				.build();

		Book expectedBook = Book.builder()
				.id(UUID.randomUUID().toString())
				.tile("Sample")
				.description("Description...")
				.numberOfPages(10)
				.publishedAt(Instant.now())
				.build();

		when(bookRepository.save(any(Book.class))).thenReturn(expectedBook);

		Book result = bookService.save(newBook);

		assertThat(result.getId()).isNotEmpty();
		assertThat(result.getTile()).isEqualTo(newBook.getTile());
	}


	@Test
	public void whenFindABookByIdShouldReturnABook() {
		String bookId = UUID.randomUUID().toString();
		Book expectedBook = Book.builder()
				.id(bookId)
				.tile("Sample")
				.description("Description...")
				.numberOfPages(10)
				.publishedAt(Instant.now())
				.build();

		when(bookRepository.findById(any(String.class))).thenReturn(Optional.of(expectedBook));

		Book book = bookService.findById(bookId);

		assertThat(book.getId()).isEqualTo(bookId);
		assertThat(book.getTile()).isEqualTo(expectedBook.getTile());
	}

	@Test
	public void whenBookNotFound() {
		String bookId = UUID.randomUUID().toString();

		when(bookRepository.findById(any(String.class))).thenReturn(Optional.empty());

		Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
			bookService.findById(bookId);
		});

		String expectedMessage = String.format("Book [%s] not found.", bookId);
		String actualMessage = exception.getMessage();

		assertThat(actualMessage).isEqualTo(expectedMessage);
		assertThat(exception).isInstanceOf(ResourceNotFoundException.class);

		ResourceNotFoundException resourceNotFoundException = (ResourceNotFoundException) exception;

		assertThat(resourceNotFoundException.getIssue()).isEqualTo(Issue.RESOURCE_NOT_FOUND);
		assertThat(resourceNotFoundException.getSeverity()).isEqualTo(Severity.ERROR);
	}


}
