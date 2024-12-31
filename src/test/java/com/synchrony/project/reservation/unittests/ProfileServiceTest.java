package com.synchrony.project.reservation.unittests;

import com.synchrony.project.reservation.entity.ProfileDetails;
import com.synchrony.project.reservation.unittests.Handlers.ProfileServiceHandler;
import com.synchrony.project.reservation.unittests.bookingservices.ProfileService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class ProfileServiceTest {
    @Mock
    private ProfileServiceHandler profileServiceHandler;

    @InjectMocks
    private ProfileService profileService;

    public ProfileServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGet() {
        Long profileId = 1L;
        ProfileDetails profileDetails = new ProfileDetails();
        profileDetails.setProfileId(profileId);

        when(profileServiceHandler.getProfileById(profileId)).thenReturn(Optional.of(profileDetails));

        Optional<ProfileDetails> result = profileService.getProfileById(profileId);
        assertTrue(result.isPresent());
        assertEquals(profileId, result.get().getProfileId());
    }

}
