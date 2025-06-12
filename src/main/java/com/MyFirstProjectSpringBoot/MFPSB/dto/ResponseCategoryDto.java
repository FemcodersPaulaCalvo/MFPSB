package com.MyFirstProjectSpringBoot.MFPSB.dto;

import com.MyFirstProjectSpringBoot.MFPSB.entity.Category;

public record ResponseCategoryDto(Long id, String name) {
    public static ResponseCategoryDto fromEntity(Category category){
        return new ResponseCategoryDto(
                category.getId(),
                category.getName()
        );

    }
}
