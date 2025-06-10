package com.MyFirstProjectSpringBoot.MFPSB.repository;

import com.MyFirstProjectSpringBoot.MFPSB.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author save(Author autor);

    Optional<Author> findByName(String name);
}
