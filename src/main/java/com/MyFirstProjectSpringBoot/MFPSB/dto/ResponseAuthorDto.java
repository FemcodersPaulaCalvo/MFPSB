package com.MyFirstProjectSpringBoot.MFPSB.dto;

import com.MyFirstProjectSpringBoot.MFPSB.entity.Author;

public record ResponseAuthorDto(Long id, String name) {
    public static ResponseAuthorDto fromEntity(Author author){
        return new ResponseAuthorDto(
                author.getId(),
                author.getName()
        );
    }
}
