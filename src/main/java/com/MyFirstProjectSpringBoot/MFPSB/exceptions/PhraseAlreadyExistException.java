package com.MyFirstProjectSpringBoot.MFPSB.exceptions;

public class PhraseAlreadyExistException extends AppException {
    public PhraseAlreadyExistException(String text, String authorName) {
        super("This phrase already exists: " + text + " Author:" + authorName + ".");
    }
}
