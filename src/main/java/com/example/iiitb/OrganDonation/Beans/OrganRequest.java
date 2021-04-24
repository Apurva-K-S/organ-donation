package com.example.iiitb.OrganDonation.Beans;

import org.springframework.stereotype.Component;

@Component
public class OrganRequest {
    private String patientFirstName;
    private String patientLastName;
    private String patientEmail;
    private String patientPhone;
    private String hospitalEmail;
    private String hospitalPhone;
    private String organ_Heart;
    private String organ_Kidney;
    private String organ_Liver;
    private String organ_Eyes;
    private String bloodGroup;

    public OrganRequest(String patientFirstName, String patientLastName, String patientEmail, String patientPhone, String hospitalEmail, String hospitalPhone, String organ_Heart, String organ_Kidney, String organ_Liver, String organ_Eyes, String bloodGroup) {
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientEmail = patientEmail;
        this.patientPhone = patientPhone;
        this.hospitalEmail = hospitalEmail;
        this.hospitalPhone = hospitalPhone;
        this.organ_Heart = organ_Heart;
        this.organ_Kidney = organ_Kidney;
        this.organ_Liver = organ_Liver;
        this.organ_Eyes = organ_Eyes;
        this.bloodGroup = bloodGroup;
    }

    public OrganRequest() {
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getHospitalEmail() {
        return hospitalEmail;
    }

    public void setHospitalEmail(String hospitalEmail) {
        this.hospitalEmail = hospitalEmail;
    }

    public String getHospitalPhone() {
        return hospitalPhone;
    }

    public void setHospitalPhone(String hospitalPhone) {
        this.hospitalPhone = hospitalPhone;
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

    public String getOrgan_Eyes() {
        return organ_Eyes;
    }

    public void setOrgan_Eyes(String organ_Eyes) {
        this.organ_Eyes = organ_Eyes;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
