package com.synchrony.project.reservation.unittests;

import com.synchrony.project.reservation.entity.ReservationDetails;
import com.synchrony.project.reservation.unittests.Handlers.ReservationServiceHandler;
import com.synchrony.project.reservation.unittests.bookingservices.ReservationService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
