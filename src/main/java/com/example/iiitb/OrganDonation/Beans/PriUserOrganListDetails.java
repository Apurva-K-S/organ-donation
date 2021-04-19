/*
this is normal java class which we r using as a template to receive data from frontend.
 */


package com.example.iiitb.OrganDonation.Beans;

public class PriUserOrganListDetails {
    private String organ_Eyes;
    private String organ_Heart;
    private String organ_Kidney;
    private String organ_Liver;
    //private String organ_Lungs;
    //private String organ_Skin;
    private String loginEmail;

    public PriUserOrganListDetails() {
    }

    public PriUserOrganListDetails(String organ_Eyes, String organ_Heart, String organ_Kidney, String organ_Liver, String loginEmail) {
        this.organ_Eyes = organ_Eyes;
        this.organ_Heart = organ_Heart;
        this.organ_Kidney = organ_Kidney;
        this.organ_Liver = organ_Liver;
        this.loginEmail = loginEmail;
    }

    public String getOrgan_Eyes() {
        return organ_Eyes;
    }

    public void setOrgan_Eyes(String organ_Eyes) {
        this.organ_Eyes = organ_Eyes;
    }

    public String getOrgan_Heart() {
        return organ_Heart;
    }

    public void setOrgan_Heart(String organ_Heart) {
        this.organ_Heart = organ_Heart;
    }

    public String getOrgan_Kidney() {
        return organ_Kidney;
    }

    public void setOrgan_Kidney(String organ_Kidney) {
        this.organ_Kidney = organ_Kidney;
    }

    public String getOrgan_Liver() {
        return organ_Liver;
    }

    public void setOrgan_Liver(String organ_Liver) {
        this.organ_Liver = organ_Liver;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }
}
