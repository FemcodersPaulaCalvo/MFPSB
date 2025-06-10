package com.MyFirstProjectSpringBoot.MFPSB.dto;

import com.MyFirstProjectSpringBoot.MFPSB.entity.Author;

public record RequestAuthorDto(String name) {
    public Author toEntity(){
        return new Author(this.name);
    }
}
