package com.programmers.blogwebsite.exceptions;

public class ResourceNotfoundException extends RuntimeException{
    String resourceName;
    String fieldName;
    long fieldValue;
    public ResourceNotfoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
    }
}
