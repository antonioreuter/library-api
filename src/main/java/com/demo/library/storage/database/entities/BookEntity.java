package com.demo.library.storage.database.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;
import java.util.Calendar;

@Entity
@Table(name="books")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookEntity {
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;

	@Column(name="title", unique = true)
	private String title;

	@Column(name="description")
	private String description;

	@Column(name="publishedAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar publishedAt;

	@Column(name="numberOfPages")
	private int numberOfPages;
}
