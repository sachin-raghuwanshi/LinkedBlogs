package com.programmers.blogwebsite.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
    String message;
    long status;
    long timeStamp;

}
