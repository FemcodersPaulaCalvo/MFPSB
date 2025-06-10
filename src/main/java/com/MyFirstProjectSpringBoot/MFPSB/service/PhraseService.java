package com.MyFirstProjectSpringBoot.MFPSB.service;

import com.MyFirstProjectSpringBoot.MFPSB.dto.ResponsePhraseDto;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Phrase;
import com.MyFirstProjectSpringBoot.MFPSB.repository.PhraseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhraseService {

    private final PhraseRepository PHRASE_REPOSITORY;

    public PhraseService(PhraseRepository phraseRepository) {
        PHRASE_REPOSITORY = phraseRepository;
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



}
