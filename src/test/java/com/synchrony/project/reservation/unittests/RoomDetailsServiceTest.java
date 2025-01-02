package com.synchrony.project.reservation.unittests;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.synchrony.project.reservation.entity.RoomDetails;
import com.synchrony.project.reservation.service.Handlers.RoomServiceHandler;
import com.synchrony.project.reservation.service.bookingservices.RoomDetailsService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class RoomDetailsServiceTest {

    @Mock
    private RoomServiceHandler roomServiceHandler;

    @InjectMocks
    private RoomDetailsService roomDetailsService;

    public RoomDetailsServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetRoomDetailsById() {
        Long roomId = 1L;
        RoomDetails roomDetails = new RoomDetails();
        roomDetails.setRoomId(roomId);

        when(roomServiceHandler.getRoomDetailsByRoomId(roomId)).thenReturn(Optional.of(roomDetails));

        Optional<RoomDetails> result = roomDetailsService.getRoomDetailsByRoomId(roomId);

        assertTrue(result.isPresent());
        assertEquals(roomId, result.get().getRoomId());
    }
}
