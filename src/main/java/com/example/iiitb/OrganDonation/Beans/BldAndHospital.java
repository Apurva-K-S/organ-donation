package com.example.iiitb.OrganDonation.Beans;

public class BldAndHospital {
    private String bloodGroup;
    private String hospitalName;

    public BldAndHospital() {
    }

    public BldAndHospital(String bloodGroup, String hospitalName) {
        this.bloodGroup = bloodGroup;
        this.hospitalName = hospitalName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}
