package com.rentacar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)  // Kendi olusturdugumuz Exception classlarina htttp-status code  da eklemeliyiz-setlemeliyiz,zorunluluk yok ama best-practice
public class ConflictException extends  RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}



