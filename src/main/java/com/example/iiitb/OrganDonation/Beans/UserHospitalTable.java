package com.example.iiitb.OrganDonation.Beans;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="UserHospitalTable")
public class UserHospitalTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userEmail", referencedColumnName = "email")
    private primaryUser puser;

    @Column(unique = true)
    private String hospitalName;

    @Column
    private Timestamp datetime;

    public UserHospitalTable() {
    }

    public UserHospitalTable(Integer id, primaryUser puser, String hospitalName, Timestamp datetime) {
        this.id = id;
        this.puser = puser;
        this.hospitalName = hospitalName;
        this.datetime = datetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public primaryUser getPuser() {
        return puser;
    }

    public void setPuser(primaryUser puser) {
        this.puser = puser;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }
}
