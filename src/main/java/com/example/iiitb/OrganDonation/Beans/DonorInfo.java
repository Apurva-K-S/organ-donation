package com.example.iiitb.OrganDonation.Beans;

public class DonorInfo {
    private String bloodGroup;
    private String hospitalName;
    private String donorName;
    private String donatedDateAndTime;

    public DonorInfo() {
    }

    public DonorInfo(String bloodGroup, String hospitalName, String donorName, String donatedDateAndTime) {
        this.bloodGroup = bloodGroup;
        this.hospitalName = hospitalName;
        this.donorName = donorName;
        this.donatedDateAndTime = donatedDateAndTime;
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

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonatedDateAndTime() {
        return donatedDateAndTime;
    }

    public void setDonatedDateAndTime(String donatedDateAndTime) {
        this.donatedDateAndTime = donatedDateAndTime;
    }
}
