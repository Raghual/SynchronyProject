package com.synchrony.project.reservation.exceptionhandlers;

import com.synchrony.project.reservation.Errors.ErrorResponse;
import com.synchrony.project.reservation.exceptions.RoomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
//Global exception handler
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<?> handleRoomNotFoundException(RoomNotFoundException exception){
        ErrorResponse response = new ErrorResponse(LocalDate.now(), exception.getMessage(),"Room Not found");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
