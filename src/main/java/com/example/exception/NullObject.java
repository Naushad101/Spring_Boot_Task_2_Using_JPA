package com.example.exception;

public class NullObject extends RuntimeException {
    String msg;
    public NullObject(String msg){
        super(msg);
    }
}
