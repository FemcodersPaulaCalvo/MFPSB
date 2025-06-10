package com.MyFirstProjectSpringBoot.MFPSB.service;

import com.MyFirstProjectSpringBoot.MFPSB.dto.RequestPhraseDto;
import com.MyFirstProjectSpringBoot.MFPSB.dto.ResponsePhraseDto;
import com.MyFirstProjectSpringBoot.MFPSB.entity.Phrase;
import com.MyFirstProjectSpringBoot.MFPSB.repository.PhraseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //  POST NEW PHRASE
    public ResponsePhraseDto createPhrase(RequestPhraseDto requestPhraseDto){
        Optional<Phrase> isExisting = PHRASE_REPOSITORY.findByText(requestPhraseDto.text());
        if (isExisting.isPresent()){
            throw new RuntimeException("This phrase exists: " + isExisting.get().getText() + " Author:" + isExisting.get().getAuthor());
        }

        Phrase newPhrase = requestPhraseDto.toEntity();
        Phrase savedPhrase = PHRASE_REPOSITORY.save(newPhrase);
        return ResponsePhraseDto.fromEntity(savedPhrase);
    }

}
