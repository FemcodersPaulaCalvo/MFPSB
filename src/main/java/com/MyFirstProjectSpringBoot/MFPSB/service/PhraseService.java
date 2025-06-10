package com.MyFirstProjectSpringBoot.MFPSB.service;

import com.MyFirstProjectSpringBoot.MFPSB.dto.RequestAuthorDto;
import com.MyFirstProjectSpringBoot.MFPSB.dto.RequestPhraseDto;
import com.MyFirstProjectSpringBoot.MFPSB.dto.ResponseAuthorDto;
import com.MyFirstProjectSpringBoot.MFPSB.dto.ResponsePhraseDto;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Author;
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

    //  POST NEW PHRASE
    public ResponsePhraseDto createPhrase(RequestPhraseDto requestPhraseDto){
        Optional<Phrase> isExisting = PHRASE_REPOSITORY.findByText(requestPhraseDto.text());
        if (isExisting.isPresent()){
            throw new RuntimeException("This phrase exists: " + isExisting.get().getText() + " Author:" + isExisting.get().getAuthor().getName());
        }

        Phrase newPhrase = requestPhraseDto.toEntity();

        Author authorNewPhrase = newPhrase.getAuthor();
        RequestAuthorDto authorDto = new RequestAuthorDto(newPhrase.getAuthor().getName());
        ResponseAuthorDto isExistingAuthor = AUTHOR_SERVICE.findByName(authorDto);
        authorNewPhrase = new Author(isExistingAuthor.id(), isExistingAuthor.name());
        newPhrase.setAuthor(authorNewPhrase);

        Phrase savedPhrase = PHRASE_REPOSITORY.save(newPhrase);
        return ResponsePhraseDto.fromEntity(savedPhrase);
    }

}
