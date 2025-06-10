package com.MyFirstProjectSpringBoot.MFPSB.service;

import com.MyFirstProjectSpringBoot.MFPSB.entity.Author;
import com.MyFirstProjectSpringBoot.MFPSB.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository AUTHOR_REPOSITORY;

    public AuthorService(AuthorRepository AUTHOR_REPOSITORY) {
        this.AUTHOR_REPOSITORY = AUTHOR_REPOSITORY;
    }

    //  SAVE AN AUTHOR
    public Author saveAuthor(){

    }
}
