package com.MyFirstProjectSpringBoot.MFPSB.controller;

import com.MyFirstProjectSpringBoot.MFPSB.dto.RequestAuthorDto;
import com.MyFirstProjectSpringBoot.MFPSB.dto.ResponseAuthorDto;
import com.MyFirstProjectSpringBoot.MFPSB.repository.AuthorRepository;
import com.MyFirstProjectSpringBoot.MFPSB.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorRepository AUTHOR_REPOSITORY;
    private final AuthorService AUTHOR_SERVICE;

    public AuthorController(AuthorRepository AUTHOR_REPOSITORY, AuthorService AUTHOR_SERVICE) {
        this.AUTHOR_REPOSITORY = AUTHOR_REPOSITORY;
        this.AUTHOR_SERVICE = AUTHOR_SERVICE;
    }

    @PostMapping
    public ResponseEntity<ResponseAuthorDto> postNewAuthor(@RequestBody RequestAuthorDto requestAuthorDto){
        ResponseAuthorDto newAuthor = AUTHOR_SERVICE.saveAuthor(requestAuthorDto);
        return new ResponseEntity<>(newAuthor, HttpStatus.OK);
    }

}
