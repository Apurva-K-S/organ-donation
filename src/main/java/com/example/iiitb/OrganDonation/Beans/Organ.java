package com.example.iiitb.OrganDonation.Beans;


public class Organ {
    private String bloodGroup;
    private String count;
    private String donatedDay;
    private String donatedTime;
    private String donorName;
    private String hospitalName;

    public Organ() {
    }

    public Organ(String bloodGroup, String count, String donatedDay, String donatedTime, String donorName, String hospitalName) {
        this.bloodGroup = bloodGroup;
        this.count = count;
        this.donatedDay = donatedDay;
        this.donatedTime = donatedTime;
        this.donorName = donorName;
        this.hospitalName = hospitalName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDonatedDay() {
        return donatedDay;
    }

    public void setDonatedDay(String donatedDay) {
        this.donatedDay = donatedDay;
    }

    public String getDonatedTime() {
        return donatedTime;
    }

    public void setDonatedTime(String donatedTime) {
        this.donatedTime = donatedTime;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}

