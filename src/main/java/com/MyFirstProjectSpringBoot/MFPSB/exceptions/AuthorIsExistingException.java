package com.MyFirstProjectSpringBoot.MFPSB.exceptions;

public class AuthorIsExistingException extends AppException {
    public AuthorIsExistingException(String authorName) {
        super("The author: " + authorName + " already exists.");
    }
}
