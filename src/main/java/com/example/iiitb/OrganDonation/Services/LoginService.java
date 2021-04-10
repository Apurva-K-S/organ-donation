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

    /*public String authenticateUser(String loginEmail,String loginPassword)
    {
        System.out.println("Inside authenticateUser");
        System.out.println("loginEmail: " + loginEmail);
        System.out.println("loginPassword: " + loginPassword);

        List<primaryUser> loginPri=null, loginSec=null, temp=null;

        loginPri = loginRepo.findByEmail(loginEmail); // search for primary user email
        loginSec = loginRepo.findBySecondary_email(loginEmail); // search for sec user email.

        P S
        F F => return false
        F T => return true;
        T F => return true;
        T T => return true; ==> shudnt occur mostly.

        int t;

        System.out.println("loginPri: " + loginPri.get(0).getEmail() + "    " + loginPri.get(0).getSecondary_email() + loginPri.get(0).getPassword());
        System.out.println("loginSec: " + loginSec.get(0).getEmail() + "    " + loginSec.get(0).getSecondary_email() + loginSec.get(0).getPassword());

        if( (loginPri.size() == 0) && (loginSec.size() == 0))
        {
            System.out.println("both are empty");
            return "three";
        }
        else if((loginPri.size() == 0) && (loginSec.size() != 0))
        {
            temp = loginSec;
            t=2; // t=2 -> secondary user
        }
        else if((loginPri.size() != 0) && (loginSec.size() == 0))
        {
            temp = loginPri;
            t=1;
        }
        else
        {
            temp = loginPri;
            t=1;
        }


        //System.out.println("loginCredentials are: "+ loginCredentials.get(0).getEmail());
        // lgn1 = loginRepo.findBySecondary_email(loginEmail);
        // Iterator itr = loginCredentials.iterator();
        // while(itr.hasNext())
        // System.out.println("Inside login service iterator: "+itr.hasNext());


        if(t==1)
        {
            if(loginEmail.equals(temp.get(0).getEmail()))
            {
                if(loginPassword.equals(temp.get(0).getPassword()))
                {
                    return "one";
                }
                return "three";
            }
            return "three";
        }
        else
        {
            if(loginEmail.equals(temp.get(0).getSecondary_email()))
            {
                if(loginPassword.equals(temp.get(0).getPassword()))
                {
                    return "two";
                }
                return "three";
            }
            return "three";
        }
    }

    public String checkPriOrSec(String loginEmail,String loginPassword)
    {
        System.out.println("Inside checkPriOrSec spring boot!!");
        System.out.println("loginEmail: " + loginEmail);
        System.out.println("loginPassword: " + loginPassword);

        List<primaryUser> loginPri, loginSec, temp;

        logCredPri= loginRepo.findByEmail(loginEmail); // primary user
        logCredSec = loginRepo.findBySecondary_email(loginEmail); // secondary user

        if(logCredPri == null && logCredSec==null)
        {
            temp = null;
            return false;
        }
        else if(logCredPri == null)
            temp = logCredSec;
        else
            temp = logCredPri;

        System.out.println("loginCredentials are: "+ temp.get(0).getEmail());
        System.out.println("loginCredentials are: "+ temp.get(0).getSecondary_email());
        System.out.println("loginCredentials are: "+ temp.get(0).getPassword());
        System.out.println((loginEmail.equals(loginCredentials.get(0).getEmail())));
        System.out.println(loginEmail.equals(lgn1.get(0).getSecondary_email()));

        //System.out.println("loginCredentials are: "+ loginCredentials.get(0).getEmail());
        // lgn1 = loginRepo.findBySecondary_email(loginEmail);
        // Iterator itr = loginCredentials.iterator();
        // while(itr.hasNext())
        // System.out.println("Inside login service iterator: "+itr.hasNext());

        if( (loginEmail.equals(loginCredentials.get(0).getEmail()))) // primary user
            return true;
        else  // secondary user.
            return false;
        loginPri= loginRepo.findByEmail(loginEmail); // search for primary user email
        loginSec = loginRepo.findBySecondary_email(loginEmail); // search for sec user email.

        P S
        F F => return false
        F T => return true;
        T F => return true;
        T T => return true; ==> shudnt occur mostly.

        int t;

        if(loginPri == null && loginSec!=null)
        {
            temp = loginSec;
            t=2; // t=2 -> secondary user
        }
        else if(loginPri != null && loginSec == null)
        {
            temp = loginPri;
            t=1;
        }
        else
        {
            temp = loginPri;
            t=1;
        }

        if(t==1) // primary user
            return "primary";
        else  // secondary user
            return "secondary";
        // primary user -> true
        // secondary user -> false.
    } */

    public boolean authenticateUser(String loginEmail,String loginPassword) {
        return true;
    }
}
