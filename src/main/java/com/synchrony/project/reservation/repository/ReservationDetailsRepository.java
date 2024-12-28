package com.synchrony.project.reservation.repository;

import com.synchrony.project.reservation.entity.ReservationDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationDetailsRepository extends JpaRepository<ReservationDetails, Long> {
}

