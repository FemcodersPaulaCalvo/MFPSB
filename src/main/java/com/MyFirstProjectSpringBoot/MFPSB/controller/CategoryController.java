package com.MyFirstProjectSpringBoot.MFPSB.controller;


import com.MyFirstProjectSpringBoot.MFPSB.dto.RequestCategoryDto;
import com.MyFirstProjectSpringBoot.MFPSB.dto.ResponseCategoryDto;
import com.MyFirstProjectSpringBoot.MFPSB.repository.CategoryRepository;
import com.MyFirstProjectSpringBoot.MFPSB.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository CATEGORY_REPOSITORY;
    private final CategoryService   CATEGORY_SERVICE;

    public CategoryController(CategoryRepository CATEGORY_REPOSITORY, CategoryService CATEGORY_SERVICE) {
        this.CATEGORY_REPOSITORY = CATEGORY_REPOSITORY;
        this.CATEGORY_SERVICE = CATEGORY_SERVICE;
    }

    @PostMapping
    public ResponseEntity<ResponseCategoryDto> postNewCategory (@Valid @RequestBody RequestCategoryDto requestCategoryDto){
        ResponseCategoryDto newCategory = CATEGORY_SERVICE.saveCategory(requestCategoryDto);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

}
