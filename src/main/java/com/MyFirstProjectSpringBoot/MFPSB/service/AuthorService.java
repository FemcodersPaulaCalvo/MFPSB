package com.MyFirstProjectSpringBoot.MFPSB.service;

import com.MyFirstProjectSpringBoot.MFPSB.dto.RequestAuthorDto;
import com.MyFirstProjectSpringBoot.MFPSB.dto.ResponseAuthorDto;
import com.MyFirstProjectSpringBoot.MFPSB.dto.ResponsePhraseDto;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Author;
import com.MyFirstProjectSpringBoot.MFPSB.exceptions.AuthorIsExistingException;
import com.MyFirstProjectSpringBoot.MFPSB.exceptions.EmptyListException;
import com.MyFirstProjectSpringBoot.MFPSB.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
            throw new AuthorIsExistingException(newAuthor.getName());
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

    //   FIND ALL
    public List<ResponseAuthorDto> findAll(){
        List<Author> listAllAuthors = AUTHOR_REPOSITORY.findAll();
        if (listAllAuthors.isEmpty()){
            throw new EmptyListException();
        }
        return listAllAuthors.stream()
                        .map(ResponseAuthorDto::fromEntity)
                                .toList();

    }
}
