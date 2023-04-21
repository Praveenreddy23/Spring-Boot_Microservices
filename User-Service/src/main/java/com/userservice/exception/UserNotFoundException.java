package com.userservice.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){
        super("User Not Found Exception!");
    }
    public UserNotFoundException(String message){
        super(message);
    }
    public UserNotFoundException(String message, Throwable cause){
        super(message,cause);
    }
}
