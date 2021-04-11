package com.example.iiitb.OrganDonation.Controller;


import com.example.iiitb.OrganDonation.Beans.LoginDetails;
import com.example.iiitb.OrganDonation.Beans.primaryUser;
import com.example.iiitb.OrganDonation.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

@RestController
@RequestMapping(path="/api")
//@CrossOrigin(origins = "*",allowedHeaders = "*")
public class LoginController {

    private LoginService loginService;
    private int LOGIN_AS_PRIMARY_USER = 1;
    private int LOGIN_AS_SECONDARY_USER = 2;


    @Autowired
    public LoginController(LoginService loginService)
    {
        this.loginService=loginService;
    }

    @PostMapping(path="/login", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Response userAuthentication(@RequestBody final LoginDetails logDetails)
    {

        int result=0;  // 1--> valid 0-->invalid logins

        /*System.out.println("Inside /api/login");
        System.out.println("login details are: Email: = " + logDetails.getLoginEmail() + " Password: = " + logDetails.getLoginPassword());
        System.out.println("gng to loginService.authenticateUser");
        String result = loginService.authenticateUser(logDetails.getLoginEmail(),logDetails.getLoginPassword());
        System.out.println("Came back from loginService.authenticateUser");
        System.out.println("result is: " + result);

        if(result.equals("three"))
            return "invalid";

        return result; */

        System.out.println("Inside /api/login");
        System.out.println("login details are: Email: = " + logDetails.getLoginEmail() + " Password: = " + logDetails.getLoginPassword());
        System.out.println("Login As: "+ logDetails.getLoginAs());
        System.out.println("gng to loginService.authenticateUser");

        if(logDetails.getLoginAs().equals("Primary User"))
        {
            System.out.println("Inside LoginController-userAuth-if stmnt:");
            result = loginService.authenticateUser(logDetails.getLoginEmail(),logDetails.getLoginPassword(),LOGIN_AS_PRIMARY_USER);
        }
        else if(logDetails.getLoginAs().equals("Secondary User"))
        {
            System.out.println("Inside LoginController-userAuth-elseif stmnt:");
            result = loginService.authenticateUser(logDetails.getLoginEmail(),logDetails.getLoginPassword(),LOGIN_AS_SECONDARY_USER);
        }


        System.out.println("Came back from loginService.authenticateUser");
        System.out.println("result is: " + result);

        if(result == 0)
            return Response.status(401).build();

        return Response.ok().build();
    }
}