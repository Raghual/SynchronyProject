package com.synchrony.project.reservation.controller;

import com.synchrony.project.reservation.entity.ReservationDetails;
import com.synchrony.project.reservation.model.ReservationDetailsDTO;
import com.synchrony.project.reservation.service.bookingservices.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/reservationDetails")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/createreservation")
    public ResponseEntity<ReservationDetails> bookReservation(@RequestBody ReservationDetailsDTO reservationDetailsDTO){
        return new ResponseEntity<>(reservationService.bookReservation(reservationDetailsDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getReservation/{reservationId}")
    public ResponseEntity<ReservationDetails> getReservationById(@PathVariable Long reservationId) {
        return new ResponseEntity<>(reservationService.getReservationById(reservationId), HttpStatus.OK);
    }

}
