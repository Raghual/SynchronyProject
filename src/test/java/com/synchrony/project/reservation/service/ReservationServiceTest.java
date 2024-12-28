package com.synchrony.project.reservation.service;

import com.synchrony.project.reservation.entity.ReservationDetails;
import com.synchrony.project.reservation.repository.ProfileDetailsRepository;
import com.synchrony.project.reservation.repository.ReservationDetailsRepository;
import com.synchrony.project.reservation.repository.RoomDetailsRepository;
import com.synchrony.project.reservation.service.Handlers.ReservationServiceHandler;
import com.synchrony.project.reservation.service.bookingservices.ProfileService;
import com.synchrony.project.reservation.service.bookingservices.ReservationService;
import com.synchrony.project.reservation.service.bookingservices.RoomDetailsService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class ReservationServiceTest {
    @Mock
    private ReservationServiceHandler reservationServiceHandler;

    @InjectMocks
    private ReservationService reservationService;

    public ReservationServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGet() {
        Long reservationId = 1L;
        ReservationDetails reservationDetails = new ReservationDetails();
        reservationDetails.setId(reservationId);

        when(reservationServiceHandler.getReservationById(reservationId)).thenReturn(reservationDetails);

        ReservationDetails result = reservationService.getReservationById(reservationId);

        assertEquals(reservationId, result.getId());
    }

}
