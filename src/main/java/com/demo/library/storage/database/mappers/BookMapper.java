package com.demo.library.storage.database.mappers;

import com.demo.library.domain.models.Book;
import com.demo.library.storage.database.entities.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements EntityMapper<Book, BookEntity>{

	public Book fromEntityToDomain(BookEntity entity) {
		return Book.builder()
				.id(entity.getId())
				.tile(entity.getTitle())
				.description(entity.getDescription())
				.publishedAt(entity.getPublishedAt())
				.numberOfPages(entity.getNumberOfPages())
				.build();
	}

	public BookEntity fromDomainToEntity(Book book) {
		return BookEntity.builder()
				.id(book.getId())
				.title(book.getTile())
				.description(book.getDescription())
				.publishedAt(book.getPublishedAt())
				.numberOfPages(book.getNumberOfPages())
				.build();
	}
}
