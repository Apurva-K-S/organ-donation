package com.example.iiitb.OrganDonation.Services;
import com.example.iiitb.OrganDonation.Beans.primaryUser;
import com.example.iiitb.OrganDonation.Controller.LoginController;
import com.example.iiitb.OrganDonation.DAO.LoginRepository;
import com.example.iiitb.OrganDonation.DAO.primaryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.Iterator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@Slf4j
public class LoginService {
    LoginRepository loginRepo;
    //private static final Logger logger = LogManager.getLogger(LoginController.class);
    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
    private int LOGIN_AS_PRIMARY_USER = 1;
    private int LOGIN_AS_SECONDARY_USER = 2;


    @Autowired
    public LoginService(LoginRepository loginRepo)
    {
        logger.info("[INFO]: inside LoginService()");
        this.loginRepo = loginRepo;
    }

    public int authenticateUser(String loginEmail,String loginPassword, int loginAs)
    {
        System.out.println("\n\ninside authenticateUSer of loginservice");
        System.out.println(loginEmail + " --- " + loginPassword + " --- "+loginAs);

        List<primaryUser> login=null;

        if(loginAs == LOGIN_AS_PRIMARY_USER) {
            logger.info("[INFO]: inside if of LOGIN_AS_PRIMARY_USER");
            System.out.println("Inside Loginservice-authenticateUser-if(loginAs)");
            login = loginRepo.findByEmail(loginEmail);
        }
            else if(loginAs == LOGIN_AS_SECONDARY_USER) {
            logger.info("[INFO]: inside if of LOGIN_AS_SECONDARY_USER");
            System.out.println("Inside Loginservice-authenticateUser-elseif(loginAs)");
            login = loginRepo.findBySecondary_email(loginEmail);
        }

        if(login.size()!=0)
        {
            System.out.println("Inside authenticateUser of LoginService-authenticateUSer-login.size()!=0");
            System.out.println("from fontend email: "+loginEmail);
            System.out.println("from frontend passwd: "+loginPassword);
            System.out.println("from backend email: "+login.get(0).getEmail());
            System.out.println("from backend passwd: "+login.get(0).getPassword());

            logger.info("[INFO]: size of login is = " + login.size());


            if(loginAs == LOGIN_AS_PRIMARY_USER && loginEmail.equals(login.get(0).getEmail()) && loginPassword.equals(login.get(0).getPassword()))
            {
                System.out.println("Inside login and passwd match if of primaryuser");
                return 1;  //Email and password matches
            }
            else if (loginAs == LOGIN_AS_SECONDARY_USER && loginEmail.equals(login.get(0).getSecondary_email()) && loginPassword.equals(login.get(0).getPassword()))
            {
                System.out.println("Inside else if of secondary user");
                return 1;
            }
        }
        return 0;
    }

}
