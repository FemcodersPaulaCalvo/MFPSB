package com.MyFirstProjectSpringBoot.MFPSB.repository;

import com.MyFirstProjectSpringBoot.MFPSB.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category save(Category category);

    Optional<Category> findByName(String name);

    List<Category> findAll();
}
