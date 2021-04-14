package com.example.iiitb.OrganDonation.DAO;

import com.example.iiitb.OrganDonation.Beans.HeartAllData;
import com.example.iiitb.OrganDonation.Beans.userOrganTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeartRepository  extends CrudRepository<userOrganTable,Integer> {

    /*@Query(value="select ou.organ, pu.blood_group, count(*), min(uht.datetime) from primary_user pu, organ_user_table ou, user_hospital_table uht where pu.email = ou.user_email " +
            "and uht.user_email = pu.email and ou.organ=?1 group by ou.organ, pu.blood_group", nativeQuery = true)*/

    @Query(value="select pu.first_name, oht.hospital_name, ou.organ, pu.blood_group, oht.datetime from primary_user pu, organ_user_table ou, user_hospital_table oht " +
            "where pu.email = ou.user_email and pu.email = oht.user_email and (oht.datetime, ou.organ, pu.blood_group) in (select min(oht.datetime), ou.organ, pu.blood_group from primary_user pu, organ_user_table ou, user_hospital_table oht where pu.email = ou.user_email and pu.email = oht.user_email group by ou.organ, pu.blood_group) and ou.organ=?1", nativeQuery = true)
    List<Object[]> findByOrgan(String organ);


    @Query(value="select ou.organ, pu.blood_group, count(*), min(uht.datetime) from primary_user pu, organ_user_table ou, user_hospital_table uht where pu.email = ou.user_email " +
            "and uht.user_email = pu.email and ou.organ=?1 group by ou.organ, pu.blood_group", nativeQuery = true)
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
