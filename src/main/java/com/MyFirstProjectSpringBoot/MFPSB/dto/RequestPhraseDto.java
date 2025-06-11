package com.MyFirstProjectSpringBoot.MFPSB.dto;

import com.MyFirstProjectSpringBoot.MFPSB.entity.Author;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Category;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Phrase;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequestPhraseDto(
        @NotBlank(message = "text can not be empty")
        @Size( min = 2, message = "text must have more than 2 letters")
        String text,
        @NotBlank(message = "author can not be empty")
        @Size( min = 2, message = "author must have more than 2 letters")
        String author,
        @NotBlank(message = "category can not be empty")
        @Size( min = 2, message = "category must have more than 2 letters")
        String category) {
    public Phrase toEntity(){
        return new Phrase(
                this.text,
                new Author(author),
                new Category(category));
    }
}
