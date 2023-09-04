package com.filmland.exception;

public class FilmLandException extends Exception {

    private static final long serialVersionUID = -596109118250952380L;
    public FilmLandException(String message) {
        super(message);
    }

    public FilmLandException(Throwable cause) {
        super(cause);
    }
}
