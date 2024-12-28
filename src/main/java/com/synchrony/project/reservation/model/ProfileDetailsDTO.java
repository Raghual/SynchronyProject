package com.synchrony.project.reservation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ProfileDetailsDTO {
    private long profileId;
    private String name;
    private String mailId;
    private String mobileNumber;

    public ProfileDetailsDTO() {
    }

    public ProfileDetailsDTO(long profileId, String name, String mailId, String mobileNumber) {
        this.profileId = profileId;
        this.name = name;
        this.mailId = mailId;
        this.mobileNumber = mobileNumber;
    }

    public long getProfileId() {
        return profileId;
    }

    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
