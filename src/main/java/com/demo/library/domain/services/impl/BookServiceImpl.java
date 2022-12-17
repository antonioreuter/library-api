package com.demo.library.domain.services.impl;

import com.demo.library.domain.models.Book;
import com.demo.library.domain.repositories.BookRepository;
import com.demo.library.domain.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Optional<Book> findById(String id) {
		return this.bookRepository.findById(id);
	}

	@Override
	public List<Book> findAll() {
		return this.bookRepository.findAll();
	}

	@Override
	public Book save(Book book) {
		return this.bookRepository.save(book);
	}

	@Override
	public void delete(String id) {
		this.delete(id);
	}
}
