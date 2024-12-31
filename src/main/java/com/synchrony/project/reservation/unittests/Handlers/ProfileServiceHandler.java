package com.synchrony.project.reservation.unittests.Handlers;

import com.synchrony.project.reservation.entity.ProfileDetails;
import com.synchrony.project.reservation.mapper.ProfileDetailsMapper;
import com.synchrony.project.reservation.model.ProfileDetailsDTO;
import com.synchrony.project.reservation.repository.ProfileDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProfileServiceHandler {

    @Autowired
    private ProfileDetailsRepository profileDetailsRepository;

    public ProfileDetails createProfile(ProfileDetailsDTO profileDetailsDTO) {
        ProfileDetails profileDetails = ProfileDetailsMapper.mapToProfileDetails(profileDetailsDTO);
        return profileDetailsRepository.save(profileDetails);
    }

    public Optional<ProfileDetails> getProfileById(Long id) {
        return profileDetailsRepository.findById(id);
    }
}
