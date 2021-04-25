package com.example.iiitb.OrganDonation.DAO;

import com.example.iiitb.OrganDonation.Beans.userFinalOrganTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFinalOrganTableRepository extends CrudRepository<userFinalOrganTable,Integer> {


    void deleteById(Integer id);
}
