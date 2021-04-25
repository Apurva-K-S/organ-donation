package com.example.iiitb.OrganDonation.Beans;

import org.springframework.stereotype.Component;

@Component
public class OrganResponse {

    private String donorName;
    private String donorEmail;
    private String recepientName;
    private String donorHospital;
    private String requestHospitalEmail;
    private String organ;
    private String bloodGroup;


    /*
    donorName: any;
  recepientName: any;
  donorHospital: any;
  requestHospitalEmail: any;
  organ: any;
  bloodGroup: any;


donorName: any;
  donorEmail: any;
  recepientName: any;
  donorHospital: any;
  requestHospitalEmail: any;
  organ: any;
  bloodGroup: any;

     */

    public OrganResponse() {
    }

    public OrganResponse(String donorName, String donorEmail, String recepientName, String donorHospital, String requestHospitalEmail, String organ, String bloodGroup) {
        this.donorName = donorName;
        this.donorEmail = donorEmail;
        this.recepientName = recepientName;
        this.donorHospital = donorHospital;
        this.requestHospitalEmail = requestHospitalEmail;
        this.organ = organ;
        this.bloodGroup = bloodGroup;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonorEmail() {
        return donorEmail;
    }

    public void setDonorEmail(String donorEmail) {
        this.donorEmail = donorEmail;
    }

    public String getRecepientName() {
        return recepientName;
    }

    public void setRecepientName(String recepientName) {
        this.recepientName = recepientName;
    }

    public String getDonorHospital() {
        return donorHospital;
    }

    public void setDonorHospital(String donorHospital) {
        this.donorHospital = donorHospital;
    }

    public String getRequestHospitalEmail() {
        return requestHospitalEmail;
    }

    public void setRequestHospitalEmail(String requestHospitalEmail) {
        this.requestHospitalEmail = requestHospitalEmail;
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
}
