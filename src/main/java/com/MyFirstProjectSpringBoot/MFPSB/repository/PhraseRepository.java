package com.MyFirstProjectSpringBoot.MFPSB.repository;

import com.MyFirstProjectSpringBoot.MFPSB.entity.Author;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Category;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhraseRepository extends JpaRepository<Phrase, Long> {
    List<Phrase> findAll();

    Phrase save(Phrase phrase);

    void deleteById(Long id);

    Optional<Phrase> findById(Long id);

    Optional<Phrase> findByText(String text);

    List<Phrase> findByAuthor_Name(String name);

    List<Phrase> findByCategory_Name(String name);

}
