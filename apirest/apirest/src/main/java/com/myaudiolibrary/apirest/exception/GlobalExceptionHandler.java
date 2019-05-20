package com.myaudiolibrary.apirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler
{
    //Exercice 1 - 2
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleEntityNotFoundException(EntityNotFoundException entityNotFoundException)
    {
        return entityNotFoundException.getMessage();
    }

    //Exercice 3
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleEntityNotFoundException(IllegalArgumentException illegalArgumentException)
    {
        return illegalArgumentException.getMessage();
    }

    //Excercice 4
    @ExceptionHandler(DoublonException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleEntityNotFoundException(DoublonException artistName) {

        return artistName.getMessage();
    }
}
