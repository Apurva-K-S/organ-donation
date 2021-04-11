/*

To fetch data from front end.. just a template.. for secondary user.
 */

package com.example.iiitb.OrganDonation.Beans;

public class SecUserDetails {
    private String priUserStatus;
    private String loginEmail;

    public SecUserDetails() {
    }

    public SecUserDetails(String priUserStatus, String loginEmail) {
        this.priUserStatus = priUserStatus;
        this.loginEmail = loginEmail;
    }

    public String getPriUserStatus() {
        return priUserStatus;
    }

    public void setPriUserStatus(String priUserStatus) {
        this.priUserStatus = priUserStatus;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }
}
