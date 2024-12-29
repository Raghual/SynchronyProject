package com.synchrony.project.reservation.controller;

import com.synchrony.project.reservation.Errors.ErrorResponse;
import com.synchrony.project.reservation.entity.RoomDetails;
import com.synchrony.project.reservation.exceptions.RoomNotFoundException;
import com.synchrony.project.reservation.model.RoomDetailsDTO;
import com.synchrony.project.reservation.service.bookingservices.RoomDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roomDetails")
public class RoomDetailsController {

    @Autowired
    private RoomDetailsService roomDetailsService;

    @PostMapping("/createRooms")
    public ResponseEntity<List<RoomDetails>> createRooms(@RequestBody List<RoomDetailsDTO> roomDetailsDTO){
        return new ResponseEntity<>(roomDetailsService.createRooms(roomDetailsDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getRooms")
    @Cacheable(value = "roomDetailsList")
    public List<RoomDetails> getAllRooms(){
        return roomDetailsService.getAllRooms();
    }

    //Implemented Caching and retry mechanisms
    @GetMapping("/getRoomDetails/{roomId}")
    @Retryable(maxAttempts = 3, value = RedisConnectionFailureException.class, backoff = @Backoff(delay = 2000))
    @Cacheable(key="#roomId", value = "roomDetails")
    public RoomDetails getRoomDetailsByRoomId(@PathVariable Long roomId){
        return roomDetailsService.getRoomDetailsByRoomId(roomId).orElseThrow(()->
                new RoomNotFoundException("Room Not Found for the room id : "+roomId));
    }
}
