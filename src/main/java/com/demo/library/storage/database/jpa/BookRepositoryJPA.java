package com.demo.library.storage.database.jpa;

import com.demo.library.storage.database.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepositoryJPA extends JpaRepository<BookEntity, String> {

	@Override
	void deleteById(String id);

	@Override
	Optional<BookEntity> findById(String s);

	@Override
	<S extends BookEntity> S save(S book);

	@Override
	List<BookEntity> findAll();
}
