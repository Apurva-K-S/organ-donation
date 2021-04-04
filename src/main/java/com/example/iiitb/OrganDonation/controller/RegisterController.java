package com.example.iiitb.OrganDonation.controller;

import com.example.iiitb.OrganDonation.bean.primaryUser;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping(path="api")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//(origins = "http://localhost:4200")
public class RegisterController {

    @PostMapping(path="/add")
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  ResponseEntity addUserData(primaryUser prmUser )
    {
        System.out.println("Inside RegisterController primaryUser firstname: "+prmUser.getFirstName());
        System.out.println("Inside RegisterController primaryUser lastname: "+prmUser.getLastName());

        return new ResponseEntity(HttpStatus.OK);
    }
}
