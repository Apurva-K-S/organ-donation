package com.example.iiitb.OrganDonation.DAO;

import com.example.iiitb.OrganDonation.Beans.UserHospitalTable;
import com.example.iiitb.OrganDonation.Beans.userOrganTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreHospitalRepository  extends CrudRepository<UserHospitalTable,Integer> {
}
