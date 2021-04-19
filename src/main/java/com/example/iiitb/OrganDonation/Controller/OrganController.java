package com.example.iiitb.OrganDonation.Controller;


import com.example.iiitb.OrganDonation.Beans.Organ;
import com.example.iiitb.OrganDonation.Services.OrganServiceTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path="/api")
public class OrganController {

    private OrganServiceTwo organServiceTwo;

    @Autowired
    public OrganController(OrganServiceTwo organServiceTwo )
    {
        this.organServiceTwo = organServiceTwo;
    }

    @GetMapping(path="/getHeartOrgan", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    //@GetMapping("/secUserGetList")
    public @ResponseBody
    List<Organ> sendHeartDetails() {

        System.out.println("inside: OrganController:sendHeartDetails\n");
        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        List<Organ> hearts = organServiceTwo.getOrgnData("Heart");

        System.out.println("\ncoming out of : HeartController:sendHeartDetails\n");

        //return temph;
        return hearts;
    }

    @GetMapping(path="/getKidneyOrgan", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    //@GetMapping("/secUserGetList")
    public @ResponseBody
    List<Organ> sendKidneyDetails() {

        System.out.println("inside: OrganController:sendKidneytDetails\n");
        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        List<Organ> kidneys = organServiceTwo.getOrgnData("Kidney");

        System.out.println("\ncoming out of : OrganController:sendKidneyDetails\n");

        //return temph;
        return kidneys;
    }

    @GetMapping(path="/getLiverOrgan", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    //@GetMapping("/secUserGetList")
    public @ResponseBody
    List<Organ> sendLiverDetails() {

        System.out.println("inside: OrganController:sendLiverDetails\n");
        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        List<Organ> livers = organServiceTwo.getOrgnData("Liver");

        System.out.println("\ncoming out of : OrganController:sendLiverDetails\n");

        //return temph;
        return livers;
    }

    @GetMapping(path="/getEyesOrgan", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    //@GetMapping("/secUserGetList")
    public @ResponseBody
    List<Organ> sendEyesDetails() {

        System.out.println("inside: OrganController:sendEyesDetails\n");
        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        List<Organ> eyes = organServiceTwo.getOrgnData("Eyes");

        System.out.println("\ncoming out of : OrganController:sendEyesDetails\n");

        //return temph;
        return eyes;
    }
}
