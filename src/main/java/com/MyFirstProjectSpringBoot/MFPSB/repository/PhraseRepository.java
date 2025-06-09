package com.MyFirstProjectSpringBoot.MFPSB.repository;

import com.MyFirstProjectSpringBoot.MFPSB.entity.Author;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Category;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PhraseRepository extends JpaRepository<Phrase, Long> {
    List<Phrase> findAll();

    Phrase save(Phrase phrase);

    void deleteById(Long id);

    Optional<Phrase> findById(Long id);

    @Query("SELECT p FROM Phrases p " +
            "WHERE p.author = :name ")
    List<Phrase> getByAuthor(@Param("name") String name);

    @Query("SELECT p FROM Phrases p " +
            "WHERE p.category = :name ")
    List<Phrase> getByCategory(@Param("name") String name);

}
