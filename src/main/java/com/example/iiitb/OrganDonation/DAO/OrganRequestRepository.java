package com.example.iiitb.OrganDonation.DAO;

import com.example.iiitb.OrganDonation.Beans.OrganRequest;
import com.example.iiitb.OrganDonation.Beans.OrganResponse;
import com.example.iiitb.OrganDonation.Beans.userOrganTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Here the bean class given in the CrudRepo is dummy repo which is not needed in this repo access
@Repository
public interface OrganRequestRepository extends CrudRepository<userOrganTable,Integer> {


    @Query(value = "select pu.first_name, pu.secondary_email, oht.hospital_name, hr.hosp_email, ufot.organ, pu.blood_group, oht.datetime from primary_user pu, user_final_organ_table ufot,"+
            " user_hospital_table oht,hospital_registration hr where pu.email = ufot.user_email and pu.email = oht.user_email and hr.hosp_name = oht.hospital_name and " +
            "(oht.datetime, ufot.organ, pu.blood_group) in (select min(oht.datetime), ufot.organ, pu.blood_group from primary_user pu, user_final_organ_table ufot, user_hospital_table oht " +
            "where pu.email = ufot.user_email and pu.email = oht.user_email group by ufot.organ, pu.blood_group) and ufot.organ=?1 and pu.blood_group=?2", nativeQuery = true)
    List<Object[]> findOrganByHospital(String organ, String bloodGroup);


}

/*

select pu.first_name, pu.secondary_email, oht.hospital_name, hr.hosp_email, ufot.organ, pu.blood_group, oht.datetime from primary_user pu, user_final_organ_table ufot,
user_hospital_table oht,hospital_registration hr where pu.email = ufot.user_email and pu.email = oht.user_email and hr.hosp_name = oht.hospital_name and
(oht.datetime, ufot.organ, pu.blood_group) in (select min(oht.datetime), ufot.organ, pu.blood_group from primary_user pu, user_final_organ_table ufot, user_hospital_table oht
where pu.email = ufot.user_email and pu.email = oht.user_email group by ufot.organ, pu.blood_group) and ufot.organ="Liver" and pu.blood_group="O+"

 */