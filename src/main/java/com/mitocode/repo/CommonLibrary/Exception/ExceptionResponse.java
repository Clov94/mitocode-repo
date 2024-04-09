package com.mitocode.repo.CommonLibrary.Exception;

import lombok.Data;

import java.util.Date;

@Data
public class ExceptionResponse {

    private Date date;
    private String message;
    private String description;

    public ExceptionResponse(Date date, String message, String description) {
        this.date = date;
        this.message = message;
        this.description = description;
    }
}
