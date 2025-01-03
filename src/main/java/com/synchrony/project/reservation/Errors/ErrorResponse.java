package com.synchrony.project.reservation.Errors;

import java.time.LocalDate;

public class ErrorResponse {
    private LocalDate date;
    private String message;
    private String details;

    public ErrorResponse() {
    }

    public ErrorResponse(LocalDate date, String message, String details) {
        this.date = date;
        this.message = message;
        this.details = details;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
