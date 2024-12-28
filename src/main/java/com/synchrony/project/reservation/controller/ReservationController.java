package com.synchrony.project.reservation.controller;

import com.synchrony.project.reservation.entity.ReservationDetails;
import com.synchrony.project.reservation.model.ReservationDetailsDTO;
import com.synchrony.project.reservation.service.bookingservices.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/reservationDetails")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/createreservation")
    public ResponseEntity<ReservationDetails> bookReservation(@RequestBody ReservationDetailsDTO reservationDetailsDTO){
        return new ResponseEntity<>(reservationService.bookReservation(reservationDetailsDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getReservation/{id}")
    public ResponseEntity<ReservationDetails> getReservationById(@RequestBody Long reservationId) {
        return new ResponseEntity<>(reservationService.getReservationById(reservationId), HttpStatus.CREATED);
    }

}
