package com.example.iiitb.OrganDonation.Beans;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name="RequestResponse")
public class RequestResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String donorName;

    @Column
    private String donorEmail;

    @Column
    private String recepientName;

    @Column
    private String recepientEmail;

    @Column
    private String donorHospital;

    @Column
    private String donorHospitalEmail;

    @Column
    private String requestHospitalEmail;

    @Column
    private String organ;

    @Column
    private String bloodGroup;

    @Column
    private Integer status;  // 0->request not yet satisfied. 1->request satisfied.


    public RequestResponse() {
    }

    public RequestResponse(Integer id, String donorName, String donorEmail, String recepientName, String recepientEmail, String donorHospital, String donorHospitalEmail, String requestHospitalEmail, String organ, String bloodGroup, Integer status) {
        this.id = id;
        this.donorName = donorName;
        this.donorEmail = donorEmail;
        this.recepientName = recepientName;
        this.recepientEmail = recepientEmail;
        this.donorHospital = donorHospital;
        this.donorHospitalEmail = donorHospitalEmail;
//        this.requestHospital = requestHospital;
        this.requestHospitalEmail = requestHospitalEmail;
        this.organ = organ;
        this.bloodGroup = bloodGroup;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRecepientEmail() {
        return recepientEmail;
    }

    public void setRecepientEmail(String recepientEmail) {
        this.recepientEmail = recepientEmail;
    }

    public String getDonorHospital() {
        return donorHospital;
    }

    public void setDonorHospital(String donorHospital) {
        this.donorHospital = donorHospital;
    }

    public String getDonorHospitalEmail() {
        return donorHospitalEmail;
    }

    public void setDonorHospitalEmail(String donorHospitalEmail) {
        this.donorHospitalEmail = donorHospitalEmail;
    }

   /* public String getRequestHospital() {
        return requestHospital;
    }

    public void setRequestHospital(String requestHospital) {
        this.requestHospital = requestHospital;
    }*/

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
