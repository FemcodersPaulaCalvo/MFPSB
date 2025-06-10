package com.MyFirstProjectSpringBoot.MFPSB.dto;

import com.MyFirstProjectSpringBoot.MFPSB.entity.Author;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Category;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Phrase;

public record RequestPhraseDto(String text, Author author, Category category) {
    public Phrase toEntity(){
        return new Phrase(this.text, this.author, this.category);
    }
}
