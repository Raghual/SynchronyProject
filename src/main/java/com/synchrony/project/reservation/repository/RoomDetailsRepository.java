package com.synchrony.project.reservation.repository;

import com.synchrony.project.reservation.entity.RoomDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDetailsRepository extends JpaRepository<RoomDetails, Long> {
}
