package com.example.iiitb.OrganDonation.Beans;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="userFinalOrganTable")
public class userFinalOrganTable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name="userEmail", referencedColumnName = "email")
    private primaryUser puser;

    @Column
    private String organ;

    public userFinalOrganTable() {
    }

    public userFinalOrganTable(Integer id, primaryUser puser, String organ) {
        this.id = id;
        this.puser = puser;
        this.organ = organ;
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

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }
}
