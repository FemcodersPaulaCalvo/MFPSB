package com.MyFirstProjectSpringBoot.MFPSB.service;

import com.MyFirstProjectSpringBoot.MFPSB.dto.*;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Author;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Category;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Phrase;
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
            throw new RuntimeException("The list is empty");
        }
        return phrases.stream()
                .map(ResponsePhraseDto::fromEntity)
                .toList();
    }

    //  GET PHRASE BY ID
    public ResponsePhraseDto findPhraseById(Long id){
        Phrase isExisstingPhrase = PHRASE_REPOSITORY.findById(id)
                .orElseThrow(() -> new RuntimeException("This phrase not exist"));

        return ResponsePhraseDto.fromEntity(isExisstingPhrase);
    }

    //  POST NEW PHRASE
    public ResponsePhraseDto createPhrase(RequestPhraseDto requestPhraseDto){
        Optional<Phrase> isExisting = PHRASE_REPOSITORY.findByText(requestPhraseDto.text());
        if (isExisting.isPresent()){
            throw new RuntimeException("This phrase exists: " + isExisting.get().getText() + " Author:" + isExisting.get().getAuthor().getName());
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
        Phrase isExisstingPhrase = PHRASE_REPOSITORY.findById(id)
                .orElseThrow(() -> new RuntimeException("This phrase not exist"));

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
                .orElseThrow(() -> new RuntimeException("This phrase not exist"));

        PHRASE_REPOSITORY.deleteById(id);
    }

}
