package com.example.iiitb.OrganDonation.Beans;

import javax.persistence.Entity;
import javax.persistence.Id;


public class LoginDetails {

    private String loginEmail;
    private String loginPassword;
    private String loginAs;

    public LoginDetails() {
    }

    public LoginDetails(String loginEmail, String loginPassword, String loginAs) {
        this.loginEmail = loginEmail;
        this.loginPassword = loginPassword;
        this.loginAs = loginAs;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getLoginAs() {
        return loginAs;
    }

    public void setLoginAs(String loginAs) {
        this.loginAs = loginAs;
    }
}
