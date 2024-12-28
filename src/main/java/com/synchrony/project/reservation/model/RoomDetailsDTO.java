package com.synchrony.project.reservation.model;


public class RoomDetailsDTO {
    private long roomId;
    private long roomNumber;
    private double ratePerNight;
    private String roomType;

    public RoomDetailsDTO() {
    }

    public RoomDetailsDTO(long roomId, long roomNumber, double ratePerNight, String roomType) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.ratePerNight = ratePerNight;
        this.roomType = roomType;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getRatePerNight() {
        return ratePerNight;
    }

    public void setRatePerNight(double ratePerNight) {
        this.ratePerNight = ratePerNight;
    }
}
