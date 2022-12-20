package com.demo.library.api.v1.controllers;

import java.util.List;

import com.demo.library.api.v1.dto.CreateBookDTO;
import org.springframework.web.bind.annotation.*;

import com.demo.library.domain.models.Book;
import com.demo.library.domain.services.BookService;

@RequestMapping(value = "/api/v1/books")
@RestController
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@PostMapping()
	public Book save(@RequestBody CreateBookDTO createBookDTO) {
		Book book = createBookDTO.buildBook();

		return this.bookService.save(book);
	}

	@GetMapping(value = "/{id}")
	public Book getById(@PathVariable("id") String id) {
		return this.bookService.findById(id);
	}


	@GetMapping(value = "/")
	public List<Book> getByAll() {
		return this.bookService.findAll();
	}
}
