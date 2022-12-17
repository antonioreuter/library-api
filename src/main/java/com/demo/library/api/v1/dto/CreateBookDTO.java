package com.demo.library.api.v1.dto;

import com.demo.library.domain.models.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookDTO {
	private String title;
	private String description;
	private Instant publishedAt;
	private int numberOfPages;

	public Book buildBook() {
		return Book.builder()
				.tile(this.title)
				.description(this.description)
				.publishedAt(this.publishedAt)
				.numberOfPages(this.numberOfPages)
				.build();
	}
}
