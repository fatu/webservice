package com.olol.spring.web.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author fatu
 */
@ControllerAdvice
public class DatabaseErrorHandler {
    @ExceptionHandler(DataAccessException.class)
    public String handleDatabaseException(DataAccessException ex) {
        return "error";
    }
}
