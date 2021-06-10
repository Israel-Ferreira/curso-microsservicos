package io.codekaffee.bookservice.exceptions.handlers;

import io.codekaffee.bookservice.exceptions.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BookNotFoundException.class)
    public StandardError handleBookNotFoundException(BookNotFoundException e){
        return new StandardError(e.getLocalizedMessage(), HttpStatus.NOT_FOUND.value());
    }
}
