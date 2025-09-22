package com.javax.movieFlix.exception;

public class UsernameOrPasswordInvalidException extends RuntimeException {
    public UsernameOrPasswordInvalidException(String message){
        super(message);
    }
}
