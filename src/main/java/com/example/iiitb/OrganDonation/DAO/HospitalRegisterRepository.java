package com.example.iiitb.OrganDonation.DAO;

import com.example.iiitb.OrganDonation.Beans.HospitalNames;
import com.example.iiitb.OrganDonation.Beans.HospitalRegistration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRegisterRepository  extends CrudRepository<HospitalRegistration, Integer> {

    @Query(value="select hosp_name from hospital_registration;", nativeQuery = true)
    List<Object[]> findByHospName();

    @Query(value="select * from hospital_registration;", nativeQuery=true)
    List<HospitalRegistration> findAll();

    @Query(value="select * from hospital_registration where hosp_email=?1 and password=?2", nativeQuery = true)
    List<HospitalRegistration> findByHospEmailAndPassword(String email, String password);
}
