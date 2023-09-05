package com.filmland.exception;

/**
 * Custom exception for Filmland API
 */
public class FilmLandException extends Exception {

    private static final long serialVersionUID = -596109118250952380L;

    public FilmLandException(String message) {
        super(message);
    }
}
