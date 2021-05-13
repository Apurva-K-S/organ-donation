package com.example.iiitb.OrganDonation.Controller;

import com.example.iiitb.OrganDonation.Beans.primaryUser;
import com.example.iiitb.OrganDonation.DAO.primaryUserRepository;
import com.example.iiitb.OrganDonation.Services.RegisterService;
import com.example.iiitb.OrganDonation.Services.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.iiitb.OrganDonation.DAO.primaryUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.core.Response;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping(path="/api")
public class RegisterController {

    private primaryUserRepository primaryUserRepository;
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    private RegisterService regService;
    private SendEmailService sendEmailService;

    @Autowired
    public RegisterController(RegisterService regService, SendEmailService sendEmailService)
    {
        logger.info("[INFO]: inside RegisterController()");
        this.regService = regService;
        this.sendEmailService = sendEmailService;
    }

    @PostMapping(path="/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Response addUserData(@RequestBody final primaryUser prmUser)
    {
        logger.info("[INFO]: inside addUserData()");
        System.out.println("Inside RegisterController primaryUser firstname: "+prmUser.getFirstName());
        System.out.println("Inside RegisterController primaryUser lastname: "+prmUser.getLastName());
        System.out.println("Inside RegisterController primaryUser email: "+prmUser.getEmail());
        System.out.println("Inside RegisterController secondaryUser email: "+prmUser.getSecondary_email());
        System.out.println("Inside RegisterController primaryUser phone: "+prmUser.getPhone());
        System.out.println("Inside RegisterController secondaryUser phone: "+prmUser.getSecondary_phone());
        System.out.println("Inside RegisterController primaryUser aadhar: "+prmUser.getAadhar());
        System.out.println("Inside RegisterController secondaryUser aadhar: "+prmUser.getSecondary_aadhar());
        System.out.println("Inside RegisterController primaryUser terms and conditions: "+prmUser.getTermsConditionsCheckbox());
        System.out.println("Inside RegisterController primaryUser secondary relationship: "+prmUser.getSecondary_relationship());
        System.out.println("Inside RegisterController primaryUser Age: "+prmUser.getAge());
        System.out.println("Inside RegisterController primaryUser BloodGroup: "+prmUser.getBloodGroup());
        System.out.println("Inside RegisterController primaryUser gender: "+prmUser.getGender());
        System.out.println("Inside RegisterController primaryUser Password: "+prmUser.getPassword());
        System.out.println("Inside RegisterController secondary firstName: "+prmUser.getSecondary_first_name());
        System.out.println("Inside RegisterController secondary firstName: "+prmUser.getSecondary_last_name());

        boolean result=regService.registerUser(prmUser);
        logger.info("[INFO]: result of regService.registerUser(prmUser); = " + result);

        String msg = "You have been registered successfully.\n Your password is: " + prmUser.getPassword();
        sendEmailService.sendEmail(prmUser.getEmail(), "from OrganDonantion", msg);

        String secondaryUserMsg = "You have been selected as secondary user by " + prmUser.getFirstName() + " .\n You can access this account with YOUR email id and password: " + prmUser.getPassword();
        sendEmailService.sendEmail(prmUser.getSecondary_email(), "from OrganDonantion", secondaryUserMsg);

        if(result == false)
            return Response.status(401).build();

        return Response.ok().build();
    }
}