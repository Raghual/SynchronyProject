package com.synchrony.project.reservation.exceptions;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(String message){
        super(message);
    }
}
