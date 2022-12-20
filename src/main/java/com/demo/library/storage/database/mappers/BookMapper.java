package com.demo.library.storage.database.mappers;

import com.demo.library.domain.models.Book;
import com.demo.library.storage.database.entities.BookEntity;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class BookMapper implements EntityMapper<Book, BookEntity>{

	public Book fromEntityToDomain(BookEntity entity) {
		return Book.builder()
				.id(entity.getId())
				.tile(entity.getTitle())
				.description(entity.getDescription())
				.publishedAt(entity.getPublishedAt().toInstant())
				.numberOfPages(entity.getNumberOfPages())
				.build();
	}

	public BookEntity fromDomainToEntity(Book book) {
		Calendar publishedAt = Calendar.getInstance();
		publishedAt.setTimeInMillis(book.getPublishedAt().toEpochMilli());

		return BookEntity.builder()
				.id(book.getId())
				.title(book.getTile())
				.description(book.getDescription())
				.publishedAt(publishedAt)
				.numberOfPages(book.getNumberOfPages())
				.build();
	}
}
