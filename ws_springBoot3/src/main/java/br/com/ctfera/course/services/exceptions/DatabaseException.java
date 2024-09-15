package br.com.ctfera.course.services.exceptions;

public class DatabaseException extends RuntimeException {
    private static final long serialversionUID = 1L;

    public DatabaseException(String msg){
        super(msg);
    }
}
