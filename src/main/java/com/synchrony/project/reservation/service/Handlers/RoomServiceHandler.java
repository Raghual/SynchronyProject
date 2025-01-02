package com.synchrony.project.reservation.service.Handlers;

import com.synchrony.project.reservation.entity.RoomDetails;
import com.synchrony.project.reservation.mapper.RoomDetailsMapper;
import com.synchrony.project.reservation.model.RoomDetailsDTO;
import com.synchrony.project.reservation.repository.RoomDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RoomServiceHandler {

    @Autowired
    private RoomDetailsRepository roomDetailsRepository;


    public List<RoomDetails> createRooms(List<RoomDetailsDTO> roomDetailsDTO) {
        List<RoomDetails> roomDetails = roomDetailsDTO.stream()
                .map(RoomDetailsMapper::mapToRoomDetails) // Convert each DTO to the entity
                .collect(Collectors.toList());
        return roomDetailsRepository.saveAll(roomDetails);
    }

    public Optional<RoomDetails> getRoomDetailsByRoomId(Long roomId) {
        try {
            return roomDetailsRepository.findById(roomId);
        } catch (Exception e) {
            return handleRedisFailure(roomId);
        }
    }

    public List<RoomDetails> getAllRooms() {
        return roomDetailsRepository.findAll();
    }

    public Optional<RoomDetails> handleRedisFailure(Long roomId) {
        // Return default data or log the error
        System.out.println("Redis unavailable. Returning default RoomDetails for roomId: " + roomId);
        return Optional.of(new RoomDetails()); // Default response in case of Redis failure
    }
}
