/*

This query gives us count of #organs with particular blood_group available with us and its minimum timer. so to receive this we need 4 fields:
organ, blood_group, count, mintimer.

mysql> select ou.organ, pu.blood_group, count(*), min(uht.datetime) from primary_user pu, organ_user_table ou, user_hospital_table uht where pu.email = ou.user_email
and uht.user_email = pu.email and ou.organ="Heart" group by ou.organ, pu.blood_group;
+-------+-------------+----------+----------------------------+
| organ | blood_group | count(*) | min(uht.datetime)          |
+-------+-------------+----------+----------------------------+
| Heart | O+          |        3 | 2021-04-13 01:26:32.132000 |
| Heart | A+          |        3 | 2021-04-13 07:00:00.000000 |
+-------+-------------+----------+----------------------------+
2 rows in set (0.00 sec)


*/
package com.example.iiitb.OrganDonation.Beans;

import java.sql.Date;

public class HeartCountData {

    private String organ;
    private String blood_group;
    private Integer count;
    private Date mintimer;

    public HeartCountData() {
    }

    public HeartCountData(String organ, String blood_group, Integer count, Date mintimer) {
        this.organ = organ;
        this.blood_group = blood_group;
        this.count = count;
        this.mintimer = mintimer;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getMintimer() {
        return mintimer;
    }

    public void setMintimer(Date mintimer) {
        this.mintimer = mintimer;
    }

}
