package com.example.iiitb.OrganDonation.Beans;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;

@Entity
@Table(name="primaryUser")
public class primaryUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstName;


    @Column(nullable = false)
    private String lastName;


    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String secondary_email;

    @Column(nullable = false,unique = true)
    private String phone;

    @Column(nullable = false,unique = true)
    private String secondary_phone;

    @Column(nullable = false,unique = true)
    private String aadhar;

    @Column(nullable = false,unique = true)
    private String secondary_aadhar;

    @Column(nullable=false)
    private String termsConditionsCheckbox;

    @Column(nullable=false)
    private String secondary_relationship;

    @Column(nullable=false)
    private String age;

    @Column(nullable=false)
    private String bloodGroup;

    @Column(nullable=false)
    private String gender;

    @Column(nullable=false)
    private String password;

    @Column(nullable = false)
    private String secondary_first_name;

    @Column(nullable = false)
    private String secondary_last_name;


    public primaryUser() {
    }

    public primaryUser(Integer id, String firstName, String lastName, String email, String secondary_email, String phone, String secondary_phone, String aadhar, String secondary_aadhar, String termsConditionsCheckbox, String secondary_relationship, String age, String bloodGroup, String gender, String password, String secondary_first_name, String secondary_last_name) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.secondary_email = secondary_email;
        this.phone = phone;
        this.secondary_phone = secondary_phone;
        this.aadhar = aadhar;
        this.secondary_aadhar = secondary_aadhar;
        this.termsConditionsCheckbox = termsConditionsCheckbox;
        this.secondary_relationship = secondary_relationship;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
        this.password = password;
        this.secondary_first_name = secondary_first_name;
        this.secondary_last_name = secondary_last_name;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecondary_email() {
        return secondary_email;
    }

    public void setSecondary_email(String secondary_email) {
        this.secondary_email = secondary_email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecondary_phone() {
        return secondary_phone;
    }

    public void setSecondary_phone(String secondary_phone) {
        this.secondary_phone = secondary_phone;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getSecondary_aadhar() {
        return secondary_aadhar;
    }

    public void setSecondary_aadhar(String secondary_aadhar) {
        this.secondary_aadhar = secondary_aadhar;
    }

    public String getTermsConditionsCheckbox() {
        return termsConditionsCheckbox;
    }

    public void setTermsConditionsCheckbox(String termsConditionsCheckbox) {
        this.termsConditionsCheckbox = termsConditionsCheckbox;
    }

    public String getSecondary_relationship() {
        return secondary_relationship;
    }

    public void setSecondary_relationship(String secondary_relationship) {
        this.secondary_relationship = secondary_relationship;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecondary_first_name() {
        return secondary_first_name;
    }

    public void setSecondary_first_name(String secondary_first_name) {
        this.secondary_first_name = secondary_first_name;
    }

    public String getSecondary_last_name() {
        return secondary_last_name;
    }

    public void setSecondary_last_name(String secondary_last_name) {
        this.secondary_last_name = secondary_last_name;
    }
}