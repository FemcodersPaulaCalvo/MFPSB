package com.MyFirstProjectSpringBoot.MFPSB.dto;

import com.MyFirstProjectSpringBoot.MFPSB.entity.Author;
import jakarta.validation.constraints.*;

public record RequestAuthorDto(
        @NotBlank(message = "Name can not be empty")
        @Size( min = 2, message = "Name must have more than 2 letters")
        String name
) {
    public Author toEntity(){
        return new Author(this.name);
    }
}
