package com.example.iiitb.OrganDonation.Beans;

import javax.persistence.*;

@Entity
@Table(name="HospitalRegistration")
public class HospitalRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true, nullable = false)
    private String hospName;

    @Column(unique=true, nullable = false)
    private String hospEmail;

    @Column(unique=true, nullable = false)
    private String phone;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String pin;

    @Column(nullable = false)
    private String password;

    public HospitalRegistration() {
    }

    public HospitalRegistration(Integer id, String hospName, String hospEmail, String phone, String state, String city, String pin, String password) {
        this.id = id;
        this.hospName = hospName;
        this.hospEmail = hospEmail;
        this.phone = phone;
        this.state = state;
        this.city = city;
        this.pin = pin;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHospName() {
        return hospName;
    }

    public void setHospName(String hospName) {
        this.hospName = hospName;
    }

    public String getHospEmail() {
        return hospEmail;
    }

    public void setHospEmail(String hospEmail) {
        this.hospEmail = hospEmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
