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
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService)
    {
        this.loginService=loginService;
    }

    @PostMapping(path="/login", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Response addUserData(@RequestBody final LoginDetails logDetails)
    {

        System.out.println("Inside /api/login");
        System.out.println("login details are: Email: = " + logDetails.getLoginEmail() + " Password: = " + logDetails.getLoginPassword());
        System.out.println("gng to loginService.authenticateUser");
        boolean result = loginService.authenticateUser(logDetails.getLoginEmail(),logDetails.getLoginPassword());
        System.out.println("Came back from loginService.authenticateUser");
        System.out.println("result is: " + result);

        if(result == false)
            return Response.status(401).build();

        return Response.ok().build();
    }

}
