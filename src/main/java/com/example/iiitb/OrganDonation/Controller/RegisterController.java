package com.example.iiitb.OrganDonation.Controller;

import com.example.iiitb.OrganDonation.Beans.primaryUser;
import com.example.iiitb.OrganDonation.DAO.primaryUserRepository;
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

    @PostMapping(path="/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    //@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    //@RequestMapping( consumes = MediaType.APPLICATION_JSON)
    public @ResponseBody String addUserData(@RequestBody final primaryUser prmUser)
    {

        System.out.println("Inside RegisterController primaryUser firstname: "+prmUser.getFirstName());
        System.out.println("Inside RegisterController primaryUser lastname: "+prmUser.getLastName());

        primaryUser n = new primaryUser();
        n.setFirstName(prmUser.getFirstName());
        n.setSecondaryFirstName(prmUser.getSecondaryFirstName());
        n.setLastName(prmUser.getLastName());
        n.setSecondaryLastName(prmUser.getSecondaryLastName());
        n.setEmail(prmUser.getEmail());
        n.setSecondaryEmail(prmUser.getSecondaryEmail());
        n.setAadhar(prmUser.getAadhar());
        n.setSecondaryAadhar(prmUser.getSecondaryAadhar());
        n.setPhone(prmUser.getPhone());
        n.setSecondaryPhone(prmUser.getSecondaryPhone());
        n.setBloodGroup(prmUser.getBloodGroup());
        n.setPassword(prmUser.getPassword());
        n.setAge(prmUser.getAge());
        primaryUserRepository.save(n);

        return "Saved";
    }

    @PostMapping(path="/test")
    public void justTesting(){
        System.out.println("this is just to test");
    }
}