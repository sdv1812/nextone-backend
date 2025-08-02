package com.vdv.NExTone.exception;

import java.time.LocalDate;
import java.util.List;

public class ErrorResponse {
    private final LocalDate timestamp;
    private final Integer status;
    private final String error;
    private final String message;
    private String stackTrace;
    private String path;
    private List<ValidationError> errors;

    public static class ValidationError {
        private final String field;
        private final String message;

        public ValidationError(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
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

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    public void setErrors(List<ValidationError> errors) {
        this.errors = errors;
    }
}
