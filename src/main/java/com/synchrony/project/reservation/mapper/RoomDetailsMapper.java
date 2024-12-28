package com.synchrony.project.reservation.mapper;

import com.synchrony.project.reservation.entity.ReservationDetails;
import com.synchrony.project.reservation.entity.RoomDetails;
import com.synchrony.project.reservation.model.ReservationDetailsDTO;
import com.synchrony.project.reservation.model.RoomDetailsDTO;

public class RoomDetailsMapper {
    public static RoomDetailsDTO mapToRoomDetailsDTO(RoomDetails roomDetails) {

        return new RoomDetailsDTO(
                roomDetails.getRoomId(),
                roomDetails.getRoomNumber(),
                roomDetails.getRatePerNight(),
                roomDetails.getRoomType()
        );
    }
    public static RoomDetails mapToRoomDetails(RoomDetailsDTO roomDetailsDTO) {

        return new RoomDetails(
                roomDetailsDTO.getRoomId(),
                roomDetailsDTO.getRoomNumber(),
                roomDetailsDTO.getRatePerNight(),
                roomDetailsDTO.getRoomType()
        );
    }
}
