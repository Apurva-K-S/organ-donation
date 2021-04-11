package com.example.iiitb.OrganDonation.DAO;
import com.example.iiitb.OrganDonation.Beans.primaryUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository  extends CrudRepository<primaryUser,Integer>{
   // @Query(value = "select * from primary_user where email=?1",nativeQuery = true)
    List<primaryUser> findByEmail(String email);
    @Query(value = "select * from primary_user where secondary_email=?1",nativeQuery = true)
   List<primaryUser> findBySecondary_email(String  secondary_email);

}