package com.MyFirstProjectSpringBoot.MFPSB.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthorIsExistingException.class)
    public ResponseEntity<String> handleAuthorIsExisting(AuthorIsExistingException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CategoryIsExistingException.class)
    public ResponseEntity<String> handleCategoryIsExisting(CategoryIsExistingException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<String> handleEmptyList(EmptyListException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(NoIdPhraseFoundException.class)
    public ResponseEntity<String> handleNoIdPhraseFound(NoIdPhraseFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PhraseAlreadyExistException.class)
    public ResponseEntity<String> handlePhraseAlreadyExist(PhraseAlreadyExistException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationErrors(MethodArgumentNotValidException ex) {
        StringBuilder sb = new StringBuilder("Validation failed: ");
        ex.getBindingResult().getFieldErrors().forEach(error ->
                sb.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append("; ")
        );
        return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
    }

}
