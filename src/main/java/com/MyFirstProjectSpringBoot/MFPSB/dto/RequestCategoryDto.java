package com.MyFirstProjectSpringBoot.MFPSB.dto;

import com.MyFirstProjectSpringBoot.MFPSB.entity.Category;

public record RequestCategoryDto(String name) {
    public Category toEntity(){
        return new Category(this.name);
    }
}
