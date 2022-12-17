package com.demo.library.storage.database;

import com.demo.library.domain.models.Book;
import com.demo.library.domain.repositories.BookRepository;
import com.demo.library.storage.database.entities.BookEntity;
import com.demo.library.storage.database.jpa.BookRepositoryJPA;
import com.demo.library.storage.database.mappers.BookMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryDB implements BookRepository{
	private final BookRepositoryJPA bookRepositoryJPA;

	private final BookMapper bookMapper;

	public BookRepositoryDB(BookRepositoryJPA bookRepositoryJPA, BookMapper bookMapper) {
		this.bookRepositoryJPA = bookRepositoryJPA;
		this.bookMapper = bookMapper;
	}

	@Override
	public Optional<Book> findById(String id) {
		Optional<BookEntity> result = this.bookRepositoryJPA.findById(id);
		if (result.isEmpty()) {
			return Optional.empty();
		}

		Book book = this.bookMapper.fromEntityToDomain(result.get());
		return Optional.of(book);
	}

	@Override
	public List<Book> findAll() {
		List<BookEntity> resultSet = this.bookRepositoryJPA.findAll();
		return resultSet.stream().map(this.bookMapper::fromEntityToDomain).toList();
	}

	@Override
	public Book save(Book book) {
		BookEntity bookEntity = this.bookMapper.fromDomainToEntity(book);
		BookEntity result =  this.bookRepositoryJPA.save(bookEntity);

		return this.bookMapper.fromEntityToDomain(result);
	}

	@Override
	public void deleteById(String id) {
		this.bookRepositoryJPA.deleteById(id);
	}
}
