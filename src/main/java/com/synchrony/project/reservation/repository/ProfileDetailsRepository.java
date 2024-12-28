package com.synchrony.project.reservation.repository;

import com.synchrony.project.reservation.entity.ProfileDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileDetailsRepository extends JpaRepository<ProfileDetails, Long> {
}
