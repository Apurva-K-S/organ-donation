package com.example.iiitb.OrganDonation.Controller;


import com.example.iiitb.OrganDonation.Beans.LoginDetails;
import com.example.iiitb.OrganDonation.Beans.primaryUser;
import com.example.iiitb.OrganDonation.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    ResponseEntity addUserData(@RequestBody final LoginDetails logDetails)
    {

        boolean result = loginService.authenticateUser(logDetails.getLoginEmail(),logDetails.getLoginPassword());
        if(result == false)
            return ResponseEntity.status(401).build();

        return ResponseEntity.ok().build();
    }

}
