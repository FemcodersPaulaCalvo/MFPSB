package com.MyFirstProjectSpringBoot.MFPSB.service;

import com.MyFirstProjectSpringBoot.MFPSB.dto.RequestCategoryDto;
import com.MyFirstProjectSpringBoot.MFPSB.dto.ResponseCategoryDto;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Category;
import com.MyFirstProjectSpringBoot.MFPSB.repository.CategoryRepository;

import java.util.Optional;

public class CategoryService {

    private final CategoryRepository CATEGORY_REPOSITORY;

    public CategoryService(CategoryRepository CATEGORY_REPOSITORY) {
        this.CATEGORY_REPOSITORY = CATEGORY_REPOSITORY;
    }

    //  SAVE A CATEGORY
    public ResponseCategoryDto saveCategory(RequestCategoryDto categoryDto){
        Category newCategory = categoryDto.toEntity();
        Optional<Category> isExisting = CATEGORY_REPOSITORY.findByName(newCategory.getName());
        if(!isExisting.isEmpty()){
            throw new RuntimeException("This category already exist");
        }
        Category savedCategory = CATEGORY_REPOSITORY.save(newCategory);
        return ResponseCategoryDto.fromEntity(savedCategory);
    }
}
