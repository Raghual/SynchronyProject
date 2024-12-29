package com.synchrony.project.reservation.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "reservation_details")
@Entity
public class ReservationDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "profileId")
    private ProfileDetails profileDetails;
    @OneToOne
    @JoinColumn(name="room_id", referencedColumnName = "roomId")
    private RoomDetails roomDetails;
    private double totalRoomRate;
    private int lengthOfStay;
    private Date checkInDate;

    public ReservationDetails() {
    }

    public ReservationDetails(long id, String name, ProfileDetails profileDetails, RoomDetails roomDetails, double totalRoomRate, int lengthOfStay, Date checkInDate) {
        this.id = id;
        this.name = name;
        this.profileDetails = profileDetails;
        this.roomDetails = roomDetails;
        this.totalRoomRate = totalRoomRate;
        this.lengthOfStay = lengthOfStay;
        this.checkInDate = checkInDate;
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

    public double getTotalRoomRate() {
        return totalRoomRate;
    }

    public void setTotalRoomRate(double totalRoomRate) {
        this.totalRoomRate = totalRoomRate;
    }

    public int getLengthOfStay() {
        return lengthOfStay;
    }

    public void setLengthOfStay(int lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }
}
