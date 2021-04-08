package com.example.iiitb.OrganDonation.Beans;

import javax.persistence.Entity;
import javax.persistence.Id;


public class LoginDetails {

    private String loginEmail;
    private String loginPassword;

    public LoginDetails(String loginEmail, String loginPassword) {
        this.loginEmail = loginEmail;
        this.loginPassword = loginPassword;
    }

    public LoginDetails() {
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


}
