package com.mitocode.repo.consultorio.CommonLibrary.Exception;


public class ModelException extends RuntimeException {
    public ModelException(String message) {
        super(message);
    }

//    public static Boolean emailValidation(String email) {
//        String regexPatern = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$";
//        return Pattern.compile(regexPatern).matcher(email).find();
//    }
}
