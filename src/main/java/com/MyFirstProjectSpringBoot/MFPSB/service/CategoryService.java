package com.MyFirstProjectSpringBoot.MFPSB.service;

import com.MyFirstProjectSpringBoot.MFPSB.dto.RequestCategoryDto;
import com.MyFirstProjectSpringBoot.MFPSB.dto.ResponseCategoryDto;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Category;
import com.MyFirstProjectSpringBoot.MFPSB.exceptions.CategoryIsExistingException;
import com.MyFirstProjectSpringBoot.MFPSB.exceptions.EmptyListException;
import com.MyFirstProjectSpringBoot.MFPSB.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
            throw new CategoryIsExistingException(newCategory.getName());
        }
        Category savedCategory = CATEGORY_REPOSITORY.save(newCategory);
        return ResponseCategoryDto.fromEntity(savedCategory);
    }

    //  FIND BY NAME
    public ResponseCategoryDto findByName(RequestCategoryDto requestCategoryDto){
        Category newCategory = requestCategoryDto.toEntity();
        Optional<Category> isExisting = CATEGORY_REPOSITORY.findByName(newCategory.getName());
        if (isExisting.isPresent()){
            return ResponseCategoryDto.fromEntity(isExisting.get());
        }
        Category savedCategory = CATEGORY_REPOSITORY.save(newCategory);
        return ResponseCategoryDto.fromEntity(savedCategory);
    }

    //  FIND ALL
    public List<ResponseCategoryDto> findAll(){
        List<Category> listAllCategories = CATEGORY_REPOSITORY.findAll();
        if (listAllCategories.isEmpty()){
            throw new EmptyListException();
        }
        return listAllCategories.stream()
                .map(ResponseCategoryDto::fromEntity)
                .toList();
    }
}
