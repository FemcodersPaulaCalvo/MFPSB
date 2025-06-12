package com.MyFirstProjectSpringBoot.MFPSB.controller;

import com.MyFirstProjectSpringBoot.MFPSB.dto.RequestAuthorDto;
import com.MyFirstProjectSpringBoot.MFPSB.dto.ResponseAuthorDto;
import com.MyFirstProjectSpringBoot.MFPSB.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService AUTHOR_SERVICE;

    public AuthorController(AuthorService AUTHOR_SERVICE) {
        this.AUTHOR_SERVICE = AUTHOR_SERVICE;
    }

    @PostMapping
    public ResponseEntity<ResponseAuthorDto> postNewAuthor(@Valid @RequestBody RequestAuthorDto requestAuthorDto){
        ResponseAuthorDto newAuthor = AUTHOR_SERVICE.saveAuthor(requestAuthorDto);
        return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseAuthorDto>> getAllAuthors(){
        List<ResponseAuthorDto> listAllAuthors = AUTHOR_SERVICE.findAll();
        return new ResponseEntity<>(listAllAuthors,HttpStatus.OK);
    }

}
