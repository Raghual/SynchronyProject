package com.synchrony.project.reservation.unittests.Handlers;

import com.synchrony.project.reservation.entity.ProfileDetails;
import com.synchrony.project.reservation.entity.ReservationDetails;
import com.synchrony.project.reservation.entity.RoomDetails;
import com.synchrony.project.reservation.exceptions.RoomNotFoundException;
import com.synchrony.project.reservation.mapper.ProfileDetailsMapper;
import com.synchrony.project.reservation.mapper.ReservationDetailsMapper;
import com.synchrony.project.reservation.model.ProfileDetailsDTO;
import com.synchrony.project.reservation.model.ReservationDetailsDTO;
import com.synchrony.project.reservation.repository.ReservationDetailsRepository;
import com.synchrony.project.reservation.unittests.bookingservices.ProfileService;
import com.synchrony.project.reservation.unittests.bookingservices.RoomDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;


@Component
public class ReservationServiceHandler {
    @Autowired
    private ReservationDetailsRepository reservationDetailsRepository;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private RoomDetailsService roomDetailsService;


    // There are two apis (create profiles and get room details) will run concurrently, ensuring thread safety during read and write operations.
    public ReservationDetails bookreservation(ReservationDetailsDTO reservationDetailsDTO){
        ReservationDetails reservationDetails = ReservationDetailsMapper.mapToReservationDetails(reservationDetailsDTO);
        CompletableFuture<ProfileDetails> profileDetailsFuture =
                CompletableFuture.supplyAsync(() -> createProfile(reservationDetails));
        CompletableFuture<RoomDetails> roomDetailsFuture =
                CompletableFuture.supplyAsync(() -> getRoomDetails(reservationDetails));
        profileDetailsFuture
                .thenCombine(roomDetailsFuture, (profileDetails, roomDetails) -> {
                    // Process results when both are ready
                    double totalCalculatedRate = calculateTotalRate(reservationDetails, roomDetails);
                    reservationDetails.setTotalRoomRate(totalCalculatedRate);
                    reservationDetails.setRoomDetails(roomDetails);
                    reservationDetails.setProfileDetails(profileDetails);
                    return reservationDetailsRepository.save(reservationDetails);
                })
                .exceptionally(ex -> {
                    ex.printStackTrace(); // Handle exceptions
                    return null;
                });
        return reservationDetails;
    }

    public ReservationDetails getReservationById(Long reservationId) {
        return reservationDetailsRepository.getReferenceById(reservationId);
    }

    private double calculateTotalRate(ReservationDetails reservationDetails, RoomDetails roomDetails) {
        double totalCalculatedRate = 0;
        int lengthOfStay = reservationDetails.getLengthOfStay();
        double ratePerNight = roomDetails.getRatePerNight();
        totalCalculatedRate = ratePerNight*lengthOfStay;
        return totalCalculatedRate;
    }

    private ProfileDetails createProfile(ReservationDetails reservationDetails){
        ProfileDetailsDTO profileDetailsDTO = ProfileDetailsMapper.mapToProfileDetailsDTO(reservationDetails.getProfileDetails());
        return profileService.createProfile(profileDetailsDTO);
    }

    private RoomDetails getRoomDetails(ReservationDetails reservationDetails){
        Long roomId = reservationDetails.getRoomDetails().getRoomId();
        return roomDetailsService.getRoomDetailsByRoomId(roomId)
                .orElseThrow(() -> new RoomNotFoundException("RoomDetails not found for roomId: " + roomId));
    }


}
