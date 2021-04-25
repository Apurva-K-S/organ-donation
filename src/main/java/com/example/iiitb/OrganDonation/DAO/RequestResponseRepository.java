package com.example.iiitb.OrganDonation.DAO;

import com.example.iiitb.OrganDonation.Beans.RequestResponse;
import com.example.iiitb.OrganDonation.Beans.userFinalOrganTable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RequestResponseRepository extends CrudRepository<RequestResponse,Integer> {

    @Query(value="select donor_name, donor_email, recepient_name, donor_hospital, request_hospital_email, organ, blood_group from request_response where donor_hospital =?1 and status=0", nativeQuery=true)
    List<List<Object[]>> findByDonorHospital(String hospitalName);


    //@Transactional
    //@Modifying(clearAutomatically = true)
    //@Query(value="delete from user_final_organ_table where user_email=?1 and organ=?2", nativeQuery = true)
    @Query(value="select * from user_final_organ_table where user_email=?1 and organ=?2", nativeQuery = true)
    List<Object[]> findByDonorEmailAndOrgan(String email, String organ);



    @Query(value="select * from request_response where donor_name =?1 and organ=?2 and status=0", nativeQuery = true)
    List<RequestResponse> findByDonorNameAndOrgan(String donorName,String organ);



    @Query(value="select donor_hospital_email from request_response where donor_hospital=?1 LIMIT 1", nativeQuery = true)
    List<Object[]> findByDonorHospitalName(String hospitalName);

}
