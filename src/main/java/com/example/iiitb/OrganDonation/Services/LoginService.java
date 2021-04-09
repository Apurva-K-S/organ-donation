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
        System.out.println("Inside authenticateUser");
        System.out.println("loginEmail: " + loginEmail);
        System.out.println("loginPassword: " + loginPassword);

        List<primaryUser> loginCredentials, lgn1;

        loginCredentials= loginRepo.findByEmail(loginEmail);
        lgn1 = loginRepo.findBySecondary_email(loginEmail);

        System.out.println("loginCredentials are: "+ lgn1.get(0).getEmail());
        System.out.println("loginCredentials are: "+ lgn1.get(0).getSecondary_email());
        System.out.println("loginCredentials are: "+ lgn1.get(0).getPassword());
        System.out.println((loginEmail.equals(loginCredentials.get(0).getEmail())));
        System.out.println(loginEmail.equals(lgn1.get(0).getSecondary_email()));
        /*
        //System.out.println("loginCredentials are: "+ loginCredentials.get(0).getEmail());
        // lgn1 = loginRepo.findBySecondary_email(loginEmail);
        // Iterator itr = loginCredentials.iterator();
        // while(itr.hasNext())
        // System.out.println("Inside login service iterator: "+itr.hasNext()); */

        if( (loginEmail.equals(loginCredentials.get(0).getEmail())) ||  (loginEmail.equals(lgn1.get(0).getSecondary_email())) )
        {
            //System.out.println("inside loginEmail.. first if");
            if( (loginPassword.equals(lgn1.get(0).getPassword())) || (loginPassword.equals(loginCredentials.get(0).getPassword())))
            {
                //System.out.println("inside loginPassword... second if");
                return true;
            }
            return false;
        }
        return false;
    }
}
