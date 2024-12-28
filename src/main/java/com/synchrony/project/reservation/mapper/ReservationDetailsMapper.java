package com.synchrony.project.reservation.mapper;

import com.synchrony.project.reservation.entity.ReservationDetails;
import com.synchrony.project.reservation.entity.RoomDetails;
import com.synchrony.project.reservation.model.ReservationDetailsDTO;

import java.util.Optional;

public class ReservationDetailsMapper {
    public static ReservationDetails mapToReservationDetails(ReservationDetailsDTO reservationDetailsDTO) {
        return new ReservationDetails(
                reservationDetailsDTO.getId(),
                reservationDetailsDTO.getName(),
                reservationDetailsDTO.getProfileDetails(),
                reservationDetailsDTO.getRoomDetails(),
                reservationDetailsDTO.getTotalRoomRate(),
                reservationDetailsDTO.getLengthOfStay(),
                reservationDetailsDTO.getCheckinDate()
        );
    }
}
