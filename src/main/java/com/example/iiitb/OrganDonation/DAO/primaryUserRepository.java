package com.example.iiitb.OrganDonation.DAO;


import com.example.iiitb.OrganDonation.Beans.primaryUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface primaryUserRepository extends CrudRepository<primaryUser, Integer> {
}
