package com.enigmacamp.elibrary.exception;

public class EntityExistException extends RuntimeException{
    public EntityExistException(){
        super("Data is already Exist");
    }

    public EntityExistException(String message){
        super(message);
    }
}
