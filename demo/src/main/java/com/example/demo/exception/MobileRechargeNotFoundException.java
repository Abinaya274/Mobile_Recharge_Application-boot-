package com.example.demo.exception;

public class MobileRechargeNotFoundException extends RuntimeException {

    public MobileRechargeNotFoundException(String message) {
        super(message);
    }
}