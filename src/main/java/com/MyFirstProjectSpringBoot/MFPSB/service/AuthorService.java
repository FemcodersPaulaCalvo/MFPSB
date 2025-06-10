package com.MyFirstProjectSpringBoot.MFPSB.service;

import com.MyFirstProjectSpringBoot.MFPSB.dto.RequestAuthorDto;
import com.MyFirstProjectSpringBoot.MFPSB.dto.ResponseAuthorDto;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Author;
import com.MyFirstProjectSpringBoot.MFPSB.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository AUTHOR_REPOSITORY;

    public AuthorService(AuthorRepository AUTHOR_REPOSITORY) {
        this.AUTHOR_REPOSITORY = AUTHOR_REPOSITORY;
    }

    //  SAVE AN AUTHOR
    public ResponseAuthorDto saveAuthor(RequestAuthorDto authorDto){
        Author newAuthor = authorDto.toEntity();
        Optional<Author> isExisting = AUTHOR_REPOSITORY.findByName(newAuthor.getName());
        if (!isExisting.isEmpty()){
            throw new RuntimeException("This author already exist");
        }
        Author savedAuthor = AUTHOR_REPOSITORY.save(newAuthor);
        return ResponseAuthorDto.fromEntity(savedAuthor);
    }

    //  FIND BY NAME
    public ResponseAuthorDto findByName(RequestAuthorDto requestAuthorDto){
        Author newAuthor = requestAuthorDto.toEntity();
        Optional<Author> isExisting = AUTHOR_REPOSITORY.findByName(newAuthor.getName());
        if (isExisting.isPresent()){
            return ResponseAuthorDto.fromEntity(isExisting.get());
        }
        Author savedAuthor = AUTHOR_REPOSITORY.save(newAuthor);
        return ResponseAuthorDto.fromEntity(savedAuthor);
    }
}
