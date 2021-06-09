package io.codekaffee.cambioservice.exceptions.handlers;

import io.codekaffee.cambioservice.exceptions.CambioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CambioExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CambioNotFoundException.class)
    public StandardError handleCambioNotFoundException(CambioNotFoundException e){
        return new StandardError(e.getLocalizedMessage(), HttpStatus.NOT_FOUND.value());
    }
}
