package com.MyFirstProjectSpringBoot.MFPSB.controller;

import com.MyFirstProjectSpringBoot.MFPSB.dto.RequestAuthorDto;
import com.MyFirstProjectSpringBoot.MFPSB.dto.RequestCategoryDto;
import com.MyFirstProjectSpringBoot.MFPSB.dto.RequestPhraseDto;
import com.MyFirstProjectSpringBoot.MFPSB.dto.ResponsePhraseDto;
import com.MyFirstProjectSpringBoot.MFPSB.service.PhraseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phrases")
public class PhraseController {

    private final PhraseService PHRASE_SERVICE;

    public PhraseController(PhraseService PHRASE_SERVICE) {
        this.PHRASE_SERVICE = PHRASE_SERVICE;
    }

    @GetMapping
    public ResponseEntity<List<ResponsePhraseDto>> getAllPhrasesList(){
        List<ResponsePhraseDto> phrases = PHRASE_SERVICE.findAllPhrases();
        return new ResponseEntity<>(phrases, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsePhraseDto> getPhraseById(@PathVariable Long id){
        ResponsePhraseDto phrase = PHRASE_SERVICE.findPhraseById(id);
        return new ResponseEntity<>(phrase, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponsePhraseDto> postNewPhrase(@Valid @RequestBody RequestPhraseDto requestPhraseDto){
        ResponsePhraseDto newPhrase = PHRASE_SERVICE.createPhrase(requestPhraseDto);
        return new ResponseEntity<>(newPhrase, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponsePhraseDto> putPhrase(@PathVariable Long id,@Valid @RequestBody RequestPhraseDto requestPhraseDto){
        ResponsePhraseDto updatePhrase = PHRASE_SERVICE.updatePhrase(id, requestPhraseDto);
        return new ResponseEntity<>(updatePhrase, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePhrase(@PathVariable Long id){
        PHRASE_SERVICE.deletePhraseById(id);
        return new ResponseEntity<>("Phrase has been deleted",HttpStatus.NO_CONTENT);
    }

    @GetMapping("/author")
    public ResponseEntity<List<ResponsePhraseDto>> getPhrasesByAuthorName(@Valid @RequestBody RequestAuthorDto requestAuthorDto){
        List<ResponsePhraseDto> phrasesByAuthor = PHRASE_SERVICE.findPhrasesByAuthorName(requestAuthorDto);
        return new ResponseEntity<>(phrasesByAuthor, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<ResponsePhraseDto>> getPhrasesByCategoryName(@Valid @RequestBody RequestCategoryDto requestCategoryDto){
        List<ResponsePhraseDto> phrasesByCategory = PHRASE_SERVICE.findPhrasesByCategoryName(requestCategoryDto);
        return new ResponseEntity<>(phrasesByCategory, HttpStatus.OK);
    }

}
