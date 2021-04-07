package com.example.iiitb.OrganDonation.Services;

import com.example.iiitb.OrganDonation.Beans.primaryUser;
import com.example.iiitb.OrganDonation.DAO.primaryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.inject.Named;
import javax.validation.constraints.Null;
@Named
public class RegisterService {


    primaryUserRepository prmUsrRepo ;


    @Autowired
    public RegisterService(primaryUserRepository prmUsrRepo)
    {
        this.prmUsrRepo = prmUsrRepo;
    }

    public boolean registerUser(primaryUser prmUsr)
    {
        primaryUser temp;
        temp= prmUsrRepo.save(prmUsr);
        if(temp == null)
            return false;
        return true;
    }

}
