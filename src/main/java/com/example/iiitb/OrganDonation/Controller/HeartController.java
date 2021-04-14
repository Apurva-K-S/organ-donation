package com.example.iiitb.OrganDonation.Controller;


import com.example.iiitb.OrganDonation.Beans.HeartAllData;
import com.example.iiitb.OrganDonation.Services.HeartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path="/api")
public class HeartController {

    private HeartService heartService;

    @Autowired
    public HeartController(HeartService heartService)
    {
        this.heartService=heartService;
    }

    @GetMapping(path="/getHeartOrgan", produces = {MediaType.APPLICATION_JSON_VALUE})
    //@GetMapping("/secUserGetList")
    public @ResponseBody
    void sendHeartDetails() {

        System.out.println("inside: HeartController:sendOrganDetails\n");
        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        HeartAllData h = new HeartAllData();
        heartService.getHeartData();

        System.out.println("\ncoming out of : HeartController:sendOrganDetails\n");

        //return temph;
    }
}
