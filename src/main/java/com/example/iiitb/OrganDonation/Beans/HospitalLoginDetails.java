package com.example.iiitb.OrganDonation.Beans;

public class HospitalLoginDetails {

    private String loginEmail;
    private String loginPassword;

    public HospitalLoginDetails(String loginEmail, String loginPassword) {
        this.loginEmail = loginEmail;
        this.loginPassword = loginPassword;
    }

    public HospitalLoginDetails() {
    }

    public String getloginEmail() {
        return loginEmail;
    }

    public void setloginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getloginPassword() {
        return loginPassword;
    }

    public void setloginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
