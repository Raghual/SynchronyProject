package com.synchrony.project.reservation.service.bookingservices;

import com.synchrony.project.reservation.entity.ProfileDetails;
import com.synchrony.project.reservation.model.ProfileDetailsDTO;
import com.synchrony.project.reservation.service.Handlers.ProfileServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProfileService{

    @Autowired
    private ProfileServiceHandler profileServiceHandler;

    public ProfileDetails createProfile(ProfileDetailsDTO profileDetailsDTO) {
        return profileServiceHandler.createProfile(profileDetailsDTO);
    }

    public Optional<ProfileDetails> getProfileById(Long id) {
        return profileServiceHandler.getProfileById(id);
    }


}
