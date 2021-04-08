package com.example.iiitb.OrganDonation.Services;
import com.example.iiitb.OrganDonation.Beans.primaryUser;
import com.example.iiitb.OrganDonation.DAO.LoginRepository;
import com.example.iiitb.OrganDonation.DAO.primaryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.Iterator;
import java.util.List;

@Named
public class LoginService {
    LoginRepository loginRepo;

    @Autowired
    public LoginService(LoginRepository loginRepo)
    {
        this.loginRepo = loginRepo;
    }

    public boolean authenticateUser(String loginEmail,String loginPassword)
    {
        List<primaryUser> loginCredentials, lgn1;
       loginCredentials= loginRepo.findByEmail(loginEmail);
      // lgn1 = loginRepo.findBySecondary_email(loginEmail);

       Iterator itr = loginCredentials.iterator();

       while(itr.hasNext())
            System.out.println("Inside login service iterator: "+itr.next());

        return true;
    }


}
