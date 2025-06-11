package com.MyFirstProjectSpringBoot.MFPSB.dto;

import com.MyFirstProjectSpringBoot.MFPSB.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequestCategoryDto(
        @NotBlank(message = "Name can not be empty")
        @Size( min = 2, message = "Name must have more than 2 letters")
        String name
) {
    public Category toEntity(){
        return new Category(this.name);
    }
}
