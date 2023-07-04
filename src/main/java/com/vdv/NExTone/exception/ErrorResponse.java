package com.vdv.NExTone.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ErrorResponse {
    private final LocalDate timestamp;
    private final Integer status;
    private final String error;
    private final String message;
    private String stackTrace;
    private String path;
    private List<ValidationError> errors;

    @Getter
    public static class ValidationError {
        private final String field;
        private final String message;
        public ValidationError(String field, String message) {
            this.field = field;
            this.message = message;
        }
    }


    public ErrorResponse(Integer status,
                         String error,
                         String message) {
        this.timestamp = LocalDate.now();
        this.status = status;
        this.error = error;
        this.message = message;
    }



}
