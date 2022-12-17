package com.demo.library.domain.repositories;

import com.demo.library.domain.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
	Optional<Book> findById(String id);

	List<Book> findAll();

	Book save(Book book);

	void deleteById(String id);
}
