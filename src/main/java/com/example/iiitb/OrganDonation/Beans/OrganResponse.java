package com.example.iiitb.OrganDonation.Beans;

import org.springframework.stereotype.Component;

@Component
public class OrganResponse {

    private String patientFirstName;
    private String secondaryEmail;
    private String hospitalName;
    private String hospitalEmail;
    private String organ;
    private String bloodGroup;
    private String time;

    public OrganResponse() {
    }

    public OrganResponse(String patientFirstName, String secondaryEmail, String hospitalName, String hospitalEmail, String organ, String bloodGroup, String time) {
        this.patientFirstName = patientFirstName;
        this.secondaryEmail = secondaryEmail;
        this.hospitalName = hospitalName;
        this.hospitalEmail = hospitalEmail;
        this.organ = organ;
        this.bloodGroup = bloodGroup;
        this.time = time;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalEmail() {
        return hospitalEmail;
    }

    public void setHospitalEmail(String hospitalEmail) {
        this.hospitalEmail = hospitalEmail;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
