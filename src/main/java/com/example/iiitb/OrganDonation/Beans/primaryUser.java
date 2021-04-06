package com.example.iiitb.OrganDonation.Beans;

import javax.persistence.*;

@Entity
@Table(name="primaryUser")
public class primaryUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "secondaryFirstName", nullable = false)
    private String secondaryFirstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "secondaryLastName", nullable = false)
    private String secondaryLastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "secondaryEmail", nullable = false)
    private String secondaryEmail;

    @Column(name = "aadhar", nullable = false)
    private String aadhar;

    @Column(name = "secondaryAadhar", nullable = false)
    private String secondaryAadhar;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "secondaryPhone", nullable = false)
    private String secondaryPhone;

    @Column(name = "bloodGroup", nullable = false)
    private String bloodGroup;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer age;

    public primaryUser() {
    }

    public primaryUser(Integer id, String firstName, String secondaryFirstName, String lastName, String secondaryLastName, String email, String secondaryEmail, String aadhar, String secondaryAadhar, String phone, String secondaryPhone, String bloodGroup, String password, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.secondaryFirstName = secondaryFirstName;
        this.lastName = lastName;
        this.secondaryLastName = secondaryLastName;
        this.email = email;
        this.secondaryEmail = secondaryEmail;
        this.aadhar = aadhar;
        this.secondaryAadhar = secondaryAadhar;
        this.phone = phone;
        this.secondaryPhone = secondaryPhone;
        this.bloodGroup = bloodGroup;
        this.password = password;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondaryFirstName() {
        return secondaryFirstName;
    }

    public void setSecondaryFirstName(String secondaryFirstName) {
        this.secondaryFirstName = secondaryFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondaryLastName() {
        return secondaryLastName;
    }

    public void setSecondaryLastName(String secondaryLastName) {
        this.secondaryLastName = secondaryLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getSecondaryAadhar() {
        return secondaryAadhar;
    }

    public void setSecondaryAadhar(String secondaryAadhar) {
        this.secondaryAadhar = secondaryAadhar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
