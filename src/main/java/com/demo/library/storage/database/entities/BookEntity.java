package com.demo.library.storage.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name="books")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Column(name="title")
	private String title;

	@Column(name="description")
	private String description;

	@Column(name="publishedAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Instant publishedAt;

	@Column(name="numberOfPages")
	private int numberOfPages;
}
