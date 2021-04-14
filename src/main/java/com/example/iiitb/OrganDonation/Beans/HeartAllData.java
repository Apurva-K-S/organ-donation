/*
To receive this output we need a class with 5 fields: first_name, hospital_name, organ, blood_group, datetime (SQL type). So we r creating this class and using it.

mysql> select pu.first_name, oht.hospital_name, ou.organ, pu.blood_group, oht.datetime from primary_user pu, organ_user_table ou, user_hospital_table oht
where pu.email = ou.user_email and pu.email = oht.user_email and
(oht.datetime, ou.organ, pu.blood_group) in (select min(oht.datetime), ou.organ, pu.blood_group from primary_user pu, organ_user_table ou, user_hospital_table oht
where pu.email = ou.user_email and pu.email = oht.user_email group by ou.organ, pu.blood_group) and ou.organ="Heart";


+------------+---------------+-------+-------------+----------------------------+
| first_name | hospital_name | organ | blood_group | datetime                   |
+------------+---------------+-------+-------------+----------------------------+
| Apurva     | Hospital3     | Heart | O+          | 2021-04-13 01:26:32.132000 |
| user4      | hospital4     | Heart | A+          | 2021-04-13 07:00:00.000000 |
+------------+---------------+-------+-------------+--------------------------- Date datetime-+
2 rows in set (0.00 sec)

 */


package com.example.iiitb.OrganDonation.Beans;


import java.util.Date;

public class HeartAllData {

    private String first_name;
    private String hospital_name;
    private String organ;
    private String blood_group;
    private Date mintimer;

    public HeartAllData() {
    }

    public HeartAllData(String first_name, String hospital_name, String organ, String blood_group, Date mintimer) {
        this.first_name = first_name;
        this.hospital_name = hospital_name;
        this.organ = organ;
        this.blood_group = blood_group;
        this.mintimer = mintimer;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public Date getMintimer() {
        return mintimer;
    }

    public void setMintimer(Date mintimer) {
        this.mintimer = mintimer;
    }
}
