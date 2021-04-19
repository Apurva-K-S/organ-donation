package com.example.iiitb.OrganDonation.DAO;

import com.example.iiitb.OrganDonation.Beans.userOrganTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganRepository extends CrudRepository<userOrganTable,Integer> {

    /*@Query(value="select ou.organ, pu.blood_group, count(*), min(uht.datetime) from primary_user pu, organ_user_table ou, user_hospital_table uht where pu.email = ou.user_email " +
            "and uht.user_email = pu.email and ou.organ=?1 group by ou.organ, pu.blood_group", nativeQuery = true)*/

    @Query(value="select pu.first_name, oht.hospital_name, ufot.organ, pu.blood_group, oht.datetime from primary_user pu, user_final_organ_table ufot, user_hospital_table oht " +
            "where pu.email = ufot.user_email and pu.email = oht.user_email and (oht.datetime, ufot.organ, pu.blood_group) in (select min(oht.datetime), ufot.organ, pu.blood_group from primary_user pu, user_final_organ_table ufot, user_hospital_table oht where pu.email = ufot.user_email and pu.email = oht.user_email group by ufot.organ, pu.blood_group) and ufot.organ=?1", nativeQuery = true)
    List<Object[]> findByOrgan(String organ);


    @Query(value="select ufot.organ, pu.blood_group, count(*), min(uht.datetime) from primary_user pu, user_final_organ_table ufot, user_hospital_table uht where pu.email = ufot.user_email " +
            "and uht.user_email = pu.email and ufot.organ=?1 group by ufot.organ, pu.blood_group", nativeQuery = true)
    List<Object[]> findByOrganContaining(String organ);

    /*
    @Query(value = "select * from primary_user where secondary_email=?1",nativeQuery = true)
     List<primaryUser> findBySecondary_email(String  secondary_email);


     select pu.first_name, oht.hospital_name, ou.organ, pu.blood_group, oht.datetime from primary_user pu, organ_user_table ou,
     user_hospital_table oht where pu.email = ou.user_email and pu.email = oht.user_email and (oht.datetime, ou.organ, pu.blood_group) in
     (select min(oht.datetime), ou.organ, pu.blood_group from primary_user pu, organ_user_table ou, user_hospital_table oht where pu.email =
     ou.user_email and pu.email = oht.user_email group by ou.organ, pu.blood_group) and ou.organ="Heart";

     */

}

/*

select pu.first_name, oht.hospital_name, ufot.organ, pu.blood_group, oht.datetime from primary_user pu, user_final_organ_table ufot, user_hospital_table oht where pu.email = ufot.user_email
and pu.email = oht.user_email and (oht.datetime, ufot.organ, pu.blood_group) in (select min(oht.datetime), ufot.organ, pu.blood_group from primary_user pu, user_final_organ_table ufot,
user_hospital_table oht where pu.email = ufot.user_email and pu.email = oht.user_email group by ufot.organ, pu.blood_group) and ufot.organ="Heart";

select ufot.organ, pu.blood_group, count(*), min(uht.datetime) from primary_user pu, user_final_organ_table ufot, user_hospital_table uht where pu.email = ufot.user_email
and uht.user_email = pu.email and ufot.organ="Heart" group by ufot.organ, pu.blood_group

 */
/*
select pu.first_name, oht.hospital_name, ou.organ, pu.blood_group, oht.datetime from primary_user pu, organ_user_table ou, user_hospital_table oht where pu.email = ou.user_email and pu.email = oht.user_email and (oht.datetime, ou.organ, pu.blood_group) in (select min(oht.datetime), ou.organ, pu.blood_group from primary_user pu, organ_user_table ou, user_hospital_table oht where pu.email = ou.user_email and pu.email = oht.user_email group by ou.organ, pu.blood_group) and ou.organ="Kidney"
 */
/*

to decrement count when a request is raise do the following:

1. we will have organ name and blood group
2. using this below query

mysql> select pu.first_name, oht.hospital_name, ou.organ, pu.blood_group, oht.datetime from primary_user pu, organ_user_table ou,
user_hospital_table oht where pu.email = ou.user_email and pu.email = oht.user_email and (oht.datetime, ou.organ, pu.blood_group) in
(select min(oht.datetime), ou.organ, pu.blood_group from primary_user pu, organ_user_table ou, user_hospital_table oht where pu.email = ou.user_email and
pu.email = oht.user_email group by ou.organ, pu.blood_group) and ou.organ="Kidney";
+------------+---------------+--------+-------------+----------------------------+
| first_name | hospital_name | organ  | blood_group | datetime                   |
+------------+---------------+--------+-------------+----------------------------+
| Apurva     | Hospital3     | Kidney | O+          | 2021-04-13 01:26:32.132000 |
| user4      | hospital4     | Kidney | A+          | 2021-04-13 07:00:00.000000 |
+------------+---------------+--------+-------------+----------------------------+
2 rows in set (0.03 sec)

we will get name and organ and blood_group of the organ with min expiry time.

so we can directly query as...

mysql> select pu.first_name, oht.hospital_name, ou.organ, pu.blood_group, oht.datetime from primary_user pu,
organ_user_table ou, user_hospital_table oht where pu.email = ou.user_email and pu.email = oht.user_email and
(oht.datetime, ou.organ, pu.blood_group) in (select min(oht.datetime), ou.organ, pu.blood_group from primary_user pu,
organ_user_table ou, user_hospital_table oht where pu.email = ou.user_email and pu.email = oht.user_email group by ou.organ, pu.blood_group)
and ou.organ="Kidney" and pu.blood_group = "O+";
+------------+---------------+--------+-------------+----------------------------+
| first_name | hospital_name | organ  | blood_group | datetime                   |
+------------+---------------+--------+-------------+----------------------------+
| Apurva     | Hospital3     | Kidney | O+          | 2021-04-13 01:26:32.132000 |
+------------+---------------+--------+-------------+----------------------------+
1 row in set (0.03 sec)

mysql> select pu.first_name, oht.hospital_name, ou.organ, pu.blood_group, oht.datetime from primary_user pu,
organ_user_table ou, user_hospital_table oht where pu.email = ou.user_email and pu.email = oht.user_email and
(oht.datetime, ou.organ, pu.blood_group) in (select min(oht.datetime), ou.organ, pu.blood_group from primary_user pu,
organ_user_table ou, user_hospital_table oht where pu.email = ou.user_email and pu.email = oht.user_email group by ou.organ, pu.blood_group)
and ou.organ="Kidney" and pu.blood_group = "A+";
+------------+---------------+--------+-------------+----------------------------+
| first_name | hospital_name | organ  | blood_group | datetime                   |
+------------+---------------+--------+-------------+----------------------------+
| user4      | hospital4     | Kidney | A+          | 2021-04-13 07:00:00.000000 |
+------------+---------------+--------+-------------+----------------------------+
1 row in set (0.00 sec)

mysql>


so if we do like this we will directly get name of the person + hospital_name + organ + blood_group + datetime (min(timer))

from this use person name .. similarly we can get email id also...

3. use this email id and organ name and delete that entry from organ_user_table...

 */