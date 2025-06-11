package com.MyFirstProjectSpringBoot.MFPSB.exceptions;

public class CategoryIsExistingException extends AppException {
    public CategoryIsExistingException(String categoryName) {
        super("The category: " + categoryName + " already exists.");
    }
}
