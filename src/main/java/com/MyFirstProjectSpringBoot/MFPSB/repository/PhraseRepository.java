package com.MyFirstProjectSpringBoot.MFPSB.repository;

import com.MyFirstProjectSpringBoot.MFPSB.entity.Author;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Category;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PhraseRepository extends JpaRepository<Phrase, Long> {
    List<Phrase> findAll();

    Phrase save(Phrase phrase);

    void deleteById(Long id);

    Optional<Phrase> findById(Long id);

    List<Phrase> getByAuthor(Author author);

    List<Phrase> getByCategory(Category category);

}
