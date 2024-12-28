package com.synchrony.project.reservation.model;

import com.synchrony.project.reservation.entity.ProfileDetails;
import com.synchrony.project.reservation.entity.RoomDetails;;

import java.util.Date;


public class ReservationDetailsDTO {
    private long id;
    private String name;
    private ProfileDetails profileDetails;
    private RoomDetails roomDetails;
    private Date checkinDate;
    private int lengthOfStay;
    private double totalRoomRate;

    public ReservationDetailsDTO() {
    }

    public ReservationDetailsDTO(long id, String name, ProfileDetails profileDetails, RoomDetails roomDetails, Date checkinDate, int lengthOfStay, Double totalRoomRate) {
        this.id = id;
        this.name = name;
        this.profileDetails = profileDetails;
        this.roomDetails = roomDetails;
        this.checkinDate = checkinDate;
        this.lengthOfStay = lengthOfStay;
        this.totalRoomRate = totalRoomRate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProfileDetails getProfileDetails() {
        return profileDetails;
    }

    public void setProfileDetails(ProfileDetails profileDetails) {
        this.profileDetails = profileDetails;
    }

    public RoomDetails getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(RoomDetails roomDetails) {
        this.roomDetails = roomDetails;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public int getLengthOfStay() {
        return lengthOfStay;
    }

    public void setLengthOfStay(int lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
    }

    public double getTotalRoomRate() {
        return totalRoomRate;
    }

    public void setTotalRoomRate(double totalRoomRate) {
        this.totalRoomRate = totalRoomRate;
    }
}
