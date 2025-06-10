package com.MyFirstProjectSpringBoot.MFPSB.dto;

import com.MyFirstProjectSpringBoot.MFPSB.entity.Author;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Category;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Phrase;

public record ResponsePhraseDto(Long id, String text, String author, String category) {
    public static ResponsePhraseDto fromEntity(Phrase phrase){
        return new ResponsePhraseDto(
                phrase.getId(),
                phrase.getText(),
                phrase.getAuthor().getName(),
                phrase.getCategory().getName()
        );
    }
}
