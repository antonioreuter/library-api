package com.demo.library.domain.services;

import com.demo.library.domain.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

	Optional<Book> findById(String id);

	List<Book> findAll();

	Book save(Book book);

	void delete(String id);
}
