package com.MyFirstProjectSpringBoot.MFPSB.dto;

import com.MyFirstProjectSpringBoot.MFPSB.entity.Author;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Category;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Phrase;

public record ResponsePhraseDto(Long id, String text, Author autor, Category category) {
    public static ResponsePhraseDto fromEntity(Phrase phrase){
        return new ResponsePhraseDto(
                phrase.getId(),
                phrase.getText(),
                phrase.getAuthor(),
                phrase.getCategory()
        );
    }
}
