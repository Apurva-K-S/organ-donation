package com.example.iiitb.OrganDonation.Controller;

import com.example.iiitb.OrganDonation.Beans.primaryUser;
import com.example.iiitb.OrganDonation.DAO.primaryUserRepository;
import com.example.iiitb.OrganDonation.Services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.iiitb.OrganDonation.DAO.primaryUserRepository;

@RestController
@RequestMapping(path="/api")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//(origins = "http://localhost:4200")
public class RegisterController {

    private primaryUserRepository primaryUserRepository;

    private RegisterService regService;

    @Autowired
    public RegisterController(RegisterService regService)
    {
        this.regService=regService;
    }

    @PostMapping(path="/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity addUserData(@RequestBody final primaryUser prmUser)
    {
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

        if(result == false)
            return ResponseEntity.status(401).build();

        return ResponseEntity.ok().build();
    }
}