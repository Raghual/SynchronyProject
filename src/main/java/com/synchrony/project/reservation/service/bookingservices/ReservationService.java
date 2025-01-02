package com.synchrony.project.reservation.service.bookingservices;

import com.synchrony.project.reservation.entity.ReservationDetails;
import com.synchrony.project.reservation.model.ReservationDetailsDTO;
import com.synchrony.project.reservation.repository.ReservationDetailsRepository;
import com.synchrony.project.reservation.service.Handlers.ReservationServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationDetailsRepository reservationDetailsRepository;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private RoomDetailsService roomDetailsService;

    @Autowired
    private ReservationServiceHandler reservationServiceHandler;

    public ReservationDetails bookReservation(ReservationDetailsDTO reservationDetailsDTO) {
        return reservationServiceHandler.bookreservation(reservationDetailsDTO);
    }

    public ReservationDetails getReservationById(Long reservationId) {
        return reservationServiceHandler.getReservationById(reservationId);
    }
}
