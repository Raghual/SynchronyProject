package com.synchrony.project.reservation.mapper;

import com.synchrony.project.reservation.entity.ProfileDetails;
import com.synchrony.project.reservation.model.ProfileDetailsDTO;

public class ProfileDetailsMapper {
    public static ProfileDetailsDTO mapToProfileDetailsDTO(ProfileDetails profileDetails){
        return new ProfileDetailsDTO(
                profileDetails.getProfileId(),
                profileDetails.getName(),
                profileDetails.getMailId(),
                profileDetails.getMobileNumber()
        );
    }
    public static ProfileDetails mapToProfileDetails(ProfileDetailsDTO profileDetailsDTO){
        return new ProfileDetails(
                profileDetailsDTO.getProfileId(),
                profileDetailsDTO.getName(),
                profileDetailsDTO.getMailId(),
                profileDetailsDTO.getMobileNumber()
        );
    }
}
