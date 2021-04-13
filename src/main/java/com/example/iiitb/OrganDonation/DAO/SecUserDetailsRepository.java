package com.example.iiitb.OrganDonation.DAO;

import com.example.iiitb.OrganDonation.Beans.SecUserDetails;
import com.example.iiitb.OrganDonation.Beans.primaryUser;
import com.example.iiitb.OrganDonation.Beans.userOrganTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecUserDetailsRepository extends CrudRepository<userOrganTable,Integer> {

    @Query(value = "select * from organ_user_table where user_email=?1",nativeQuery = true)
    List<userOrganTable> findByPuserEmail(String loginEmail);

}
