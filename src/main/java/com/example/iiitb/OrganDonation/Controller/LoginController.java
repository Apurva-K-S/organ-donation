package com.example.iiitb.OrganDonation.Controller;


import com.example.iiitb.OrganDonation.Beans.LoginDetails;
import com.example.iiitb.OrganDonation.Beans.primaryUser;
import com.example.iiitb.OrganDonation.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.core.Response;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping(path="/api")
@CrossOrigin(origins = "*")
public class LoginController {

    private LoginService loginService;
    private int LOGIN_AS_PRIMARY_USER = 1;
    private int LOGIN_AS_SECONDARY_USER = 2;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    //private static final Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    public LoginController(LoginService loginService)
    {
        logger.info("[INFO]: inside LoginController()");
        this.loginService=loginService;
    }

    @PostMapping(path="/login", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Response userAuthentication(@RequestBody final LoginDetails logDetails)
    {

        int result=0;  // 1--> valid 0-->invalid logins

        logger.info("[INFO]: inside userAuthentication()");logger.info("[INFO]: inside userAuthentication()");
        logger.info("[INFO]: values are = " + logDetails.getLoginEmail() + " ---  " + logDetails.getLoginPassword() + " --- " + logDetails.getLoginAs());

        System.out.println("Inside /api/login");
        System.out.println("login details are: Email: = " + logDetails.getLoginEmail() + " Password: = " + logDetails.getLoginPassword());
        System.out.println("Login As: "+ logDetails.getLoginAs());
        System.out.println("gng to loginService.authenticateUser");

        if(logDetails.getLoginAs().equals("Primary User"))
        {
            System.out.println("Inside LoginController-userAuth-if stmnt:");
            logger.info("[INFO]: Inside LoginController-userAuth-if Primary User stmnt:");
            System.out.println("chekcing loginservice object =   " + loginService);
            System.out.println("LOGIN_AS_PRIMARY_USER  " + LOGIN_AS_PRIMARY_USER);
            if(Objects.isNull(loginService))
            {
                System.out.println("loginService object is null");
            };

            result = loginService.authenticateUser(logDetails.getLoginEmail(),logDetails.getLoginPassword(),LOGIN_AS_PRIMARY_USER);
        }
        else if(logDetails.getLoginAs().equals("Secondary User"))
        {
            System.out.println("Inside LoginController-userAuth-elseif stmnt:");
            logger.info("[INFO]: Inside LoginController-userAuth-elseif stmnt:");
            result = loginService.authenticateUser(logDetails.getLoginEmail(),logDetails.getLoginPassword(),LOGIN_AS_SECONDARY_USER);
        }

        System.out.println("Came back from loginService.authenticateUser");
        System.out.println("result is: " + result);
        logger.info("[INFO]: result = " + result);

        if(result == 0)
            return Response.status(401).build();

        return Response.ok().build();
    }

}