package com.MyFirstProjectSpringBoot.MFPSB.exceptions;

public class NoIdPhraseFoundException extends AppException {
    public NoIdPhraseFoundException(Long id) {
        super("The id: " + id + " does not exist.");
    }
}
