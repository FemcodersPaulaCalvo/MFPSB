package com.MyFirstProjectSpringBoot.MFPSB.service;

import com.MyFirstProjectSpringBoot.MFPSB.dto.*;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Author;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Category;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Phrase;
import com.MyFirstProjectSpringBoot.MFPSB.exceptions.EmptyListException;
import com.MyFirstProjectSpringBoot.MFPSB.exceptions.NoIdPhraseFoundException;
import com.MyFirstProjectSpringBoot.MFPSB.exceptions.PhraseAlreadyExistException;
import com.MyFirstProjectSpringBoot.MFPSB.repository.PhraseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhraseService {

    private final PhraseRepository PHRASE_REPOSITORY;

    private final AuthorService AUTHOR_SERVICE;

    private final CategoryService CATEGORY_SERVICE;

    public PhraseService(PhraseRepository PHRASE_REPOSITORY, AuthorService AUTHOR_SERVICE, CategoryService CATEGORY_SERVICE) {
        this.PHRASE_REPOSITORY = PHRASE_REPOSITORY;
        this.AUTHOR_SERVICE = AUTHOR_SERVICE;
        this.CATEGORY_SERVICE = CATEGORY_SERVICE;
    }

    //  GET ALL PHRASES
    public List<ResponsePhraseDto> findAllPhrases(){
        List<Phrase> phrases = PHRASE_REPOSITORY.findAll();
        if (phrases.isEmpty()){
            throw new EmptyListException();
        }
        return phrases.stream()
                .map(ResponsePhraseDto::fromEntity)
                .toList();
    }

    //  GET PHRASE BY ID
    public ResponsePhraseDto findPhraseById(Long id){
        Phrase isExisstingPhrase = PHRASE_REPOSITORY.findById(id)
                .orElseThrow(() -> new NoIdPhraseFoundException(id));

        return ResponsePhraseDto.fromEntity(isExisstingPhrase);
    }

    //  POST NEW PHRASE
    public ResponsePhraseDto createPhrase(RequestPhraseDto requestPhraseDto){
        Optional<Phrase> isExisting = PHRASE_REPOSITORY.findByText(requestPhraseDto.text());
        if (isExisting.isPresent()){
            throw new PhraseAlreadyExistException(isExisting.get().getText(), isExisting.get().getAuthor().getName());
        }

        Phrase newPhrase = requestPhraseDto.toEntity();

        RequestAuthorDto authorDto = new RequestAuthorDto(newPhrase.getAuthor().getName());
        ResponseAuthorDto isExistingAuthor = AUTHOR_SERVICE.findByName(authorDto);
        Author authorNewPhrase = new Author(isExistingAuthor.id(), isExistingAuthor.name());
        newPhrase.setAuthor(authorNewPhrase);

        RequestCategoryDto categoryDto = new RequestCategoryDto(newPhrase.getCategory().getName());
        ResponseCategoryDto isExistingCategory = CATEGORY_SERVICE.findByName(categoryDto);
        Category categoryNewPhrase = new Category(isExistingCategory.id(), isExistingCategory.name());
        newPhrase.setCategory(categoryNewPhrase);

        Phrase savedPhrase = PHRASE_REPOSITORY.save(newPhrase);
        return ResponsePhraseDto.fromEntity(savedPhrase);
    }

    //  UPDATE PHRASE
    public ResponsePhraseDto updatePhrase(Long id, RequestPhraseDto requestPhraseDto){
        Optional<Phrase> isExisting = PHRASE_REPOSITORY.findByText(requestPhraseDto.text());
        if (isExisting.isPresent()){
            throw new PhraseAlreadyExistException(isExisting.get().getText(), isExisting.get().getAuthor().getName());
        }
        Phrase isExisstingPhrase = PHRASE_REPOSITORY.findById(id)
                .orElseThrow(() -> new NoIdPhraseFoundException(id));

        isExisstingPhrase.setText(requestPhraseDto.text());

        Phrase newPhrase = requestPhraseDto.toEntity();

        RequestAuthorDto authorDto = new RequestAuthorDto(newPhrase.getAuthor().getName());
        ResponseAuthorDto isExistingAuthor = AUTHOR_SERVICE.findByName(authorDto);
        Author authorNewPhrase = new Author(isExistingAuthor.id(), isExistingAuthor.name());
        isExisstingPhrase.setAuthor(authorNewPhrase);

        RequestCategoryDto categoryDto = new RequestCategoryDto(newPhrase.getCategory().getName());
        ResponseCategoryDto isExistingCategory = CATEGORY_SERVICE.findByName(categoryDto);
        Category categoryNewPhrase = new Category(isExistingCategory.id(), isExistingCategory.name());
        isExisstingPhrase.setCategory(categoryNewPhrase);


        Phrase updatedPhrase = PHRASE_REPOSITORY.save(isExisstingPhrase);

        return ResponsePhraseDto.fromEntity(updatedPhrase);
    }

    //  DELETE PHRASE
    public void deletePhraseById(Long id){
        Phrase isExisstingPhrase = PHRASE_REPOSITORY.findById(id)
                .orElseThrow(() -> new NoIdPhraseFoundException(id));

        PHRASE_REPOSITORY.deleteById(id);
    }

    //  FIND PHRASES BY AUTHOR
    public List<ResponsePhraseDto> findPhrasesByAuthorName(RequestAuthorDto requestAuthorDto){
        List<Phrase> isExistingPhrasesByAuthor = PHRASE_REPOSITORY.findByAuthor_Name(requestAuthorDto.name());
        if (isExistingPhrasesByAuthor.isEmpty()){
            throw new RuntimeException("This author not have phrases");
        }
        return isExistingPhrasesByAuthor.stream()
                .map(ResponsePhraseDto::fromEntity)
                .toList();    }

}
