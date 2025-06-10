package com.MyFirstProjectSpringBoot.MFPSB.controller;

import com.MyFirstProjectSpringBoot.MFPSB.dto.RequestPhraseDto;
import com.MyFirstProjectSpringBoot.MFPSB.dto.ResponsePhraseDto;
import com.MyFirstProjectSpringBoot.MFPSB.repository.PhraseRepository;
import com.MyFirstProjectSpringBoot.MFPSB.service.PhraseService;
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

    @PostMapping
    public ResponseEntity<ResponsePhraseDto> postNewPhrase(@RequestBody RequestPhraseDto requestPhraseDto){
        ResponsePhraseDto newPhrase = PHRASE_SERVICE.createPhrase(requestPhraseDto);
        return new ResponseEntity<>(newPhrase, HttpStatus.OK);
    }
}
