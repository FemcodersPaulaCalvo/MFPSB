package com.MyFirstProjectSpringBoot.MFPSB.controller;

import com.MyFirstProjectSpringBoot.MFPSB.dto.ResponsePhraseDto;
import com.MyFirstProjectSpringBoot.MFPSB.repository.PhraseRepository;
import com.MyFirstProjectSpringBoot.MFPSB.service.PhraseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/phrases")
public class PhraseController {
    private final PhraseRepository PHRASE_REPOSITORY;
    private final PhraseService PHRASE_SERVICE;

    public PhraseController(PhraseRepository PHRASE_REPOSITORY, PhraseService PHRASE_SERVICE) {
        this.PHRASE_REPOSITORY = PHRASE_REPOSITORY;
        this.PHRASE_SERVICE = PHRASE_SERVICE;
    }

    @GetMapping
    public ResponseEntity<List<ResponsePhraseDto>> getCardList(){
        List<ResponsePhraseDto> phrases = PHRASE_SERVICE.findAllPhrases();
        return new ResponseEntity<>(phrases, HttpStatus.OK);
    }
}
