package com.synchrony.project.reservation.service.bookingservices;

import com.synchrony.project.reservation.entity.RoomDetails;
import com.synchrony.project.reservation.model.RoomDetailsDTO;
import com.synchrony.project.reservation.service.Handlers.RoomServiceHandler;
import jakarta.persistence.Cacheable;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomDetailsService {

    @Autowired
    private RoomServiceHandler roomServiceHandler;

    public List<RoomDetails> createRooms(List<RoomDetailsDTO> roomDetailsDTO) {
        return roomServiceHandler.createRooms(roomDetailsDTO);
    }

    public Optional<RoomDetails> getRoomDetailsByRoomId(Long roomId) {
        return roomServiceHandler.getRoomDetailsByRoomId(roomId);
    }

    public List<RoomDetails> getAllRooms() {
        return roomServiceHandler.getAllRooms();
    }

}
