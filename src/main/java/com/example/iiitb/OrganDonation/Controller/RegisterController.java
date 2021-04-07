package com.example.iiitb.OrganDonation.Controller;

import com.example.iiitb.OrganDonation.Beans.primaryUser;
import com.example.iiitb.OrganDonation.DAO.primaryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.example.iiitb.OrganDonation.DAO.primaryUserRepository;
import com.example.iiitb.OrganDonation.Services.*;



@RestController
@RequestMapping(path="/api")
@Component
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
    //@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    //@RequestMapping( consumes = MediaType.APPLICATION_JSON)
    public @ResponseBody ResponseEntity addUserData(@RequestBody final primaryUser prmUser)
    {

        System.out.println("Inside RegisterController primaryUser firstname: "+prmUser.getFirstName());
        System.out.println("Inside RegisterController primaryUser lastname: "+prmUser.getLastName());
        System.out.println("Inside COntroler secondary aadhar value: "+prmUser.getSecondaryAadhar());//
        System.out.println("Inside COntroler aadhar value: "+prmUser.getAadhar());
        System.out.println("Inside COntroler secondary email value: "+prmUser.getSecondaryEmail());
        System.out.println("Inside COntroler email value: "+prmUser.getEmail());//
        System.out.println("Inside COntroler secondary first value: "+prmUser.getSecondaryFirstName());
        System.out.println("Inside COntroler secondary last value: "+prmUser.getSecondaryLastName());
        System.out.println("Inside COntroler password value: "+prmUser.getPassword());
        System.out.println("Inside COntroler phone value: "+prmUser.getPhone());
        System.out.println("Inside COntroler secondary phone value: "+prmUser.getSecondaryPhone());
        System.out.println("Inside COntroler age value: "+prmUser.getAge());

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
      //  primaryUserRepository.save(n);

        boolean result=regService.registerUser(prmUser);

        if(result == false)
                return ResponseEntity.status(401).build();


        return ResponseEntity.ok().build();
    }

    @PostMapping(path="/test")
    public void justTesting(){
        System.out.println("this is just to test");
    }
}