package com.example.iiitb.OrganDonation.Controller;


import com.example.iiitb.OrganDonation.Beans.*;
import com.example.iiitb.OrganDonation.Services.OrganServiceTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public @ResponseBody List<Organ> sendHeartDetails() {

        System.out.println("inside: OrganController:sendHeartDetails\n");
        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        List<Organ> hearts = organServiceTwo.getOrgnData("Heart");

        System.out.println("\ncoming out of : HeartController:sendHeartDetails\n");

        //return temph;
        return hearts;
    }


    @GetMapping(path="/getDonorInfo", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<DonorInfo> getDonorInfo(final BldAndHospital bldAndHospital) {

        System.out.println("");
        System.out.println("inside SecUserDetailsController-getDonorInfo ");
        System.out.println("all details: " + bldAndHospital.getBloodGroup()  + "   " + bldAndHospital.getHospitalName());
        System.out.println("\n\n check:--" + bldAndHospital.getBloodGroup()+"--");

        String bldGrp = bldAndHospital.getBloodGroup();

        if(bldAndHospital.getBloodGroup().equals("A ") || bldAndHospital.getBloodGroup().equals("B ") || bldAndHospital.getBloodGroup().equals("O ") || bldAndHospital.getBloodGroup().equals("AB "))
        {
            String[] bG = bldAndHospital.getBloodGroup().split(" ", 3);
            bldGrp = bG[0] + "+";
        }

        System.out.println("bldgrp = " + bldGrp);
        List<DonorInfo> sample = organServiceTwo.getDonorInfo("Heart", bldGrp, bldAndHospital.getHospitalName());

        System.out.println("\n\ninside SecUserDetailsController-getDonorInfo\n\n");

        for(int i=0;i<sample.size();i++)
        {
            System.out.println(sample.get(i).getBloodGroup() +" " + sample.get(i).getHospitalName() + " " + sample.get(i).getDonorName() + " " + sample.get(i).getDonatedDateAndTime() + "\n");
        }

        return sample;
    }


    @GetMapping(path="/getKidneyDonorInfo", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<DonorInfo> getKidneyDonorInfo(final BldAndHospital bldAndHospital) {

        System.out.println("");
        System.out.println("inside SecUserDetailsController-getKidneyDonorInfo ");
        System.out.println("all details: " + bldAndHospital.getBloodGroup()  + "   " + bldAndHospital.getHospitalName());
        System.out.println("\n\n check:--" + bldAndHospital.getBloodGroup()+"--");

        String bldGrp = bldAndHospital.getBloodGroup();

        if(bldAndHospital.getBloodGroup().equals("A ") || bldAndHospital.getBloodGroup().equals("B ") || bldAndHospital.getBloodGroup().equals("O ") || bldAndHospital.getBloodGroup().equals("AB "))
        {
            String[] bG = bldAndHospital.getBloodGroup().split(" ", 3);
            bldGrp = bG[0] + "+";
        }

        System.out.println("bldgrp = " + bldGrp);
        List<DonorInfo> sample = organServiceTwo.getDonorInfo("Kidney", bldGrp, bldAndHospital.getHospitalName());

        System.out.println("\n\ninside SecUserDetailsController-getDonorInfo\n\n");

        for(int i=0;i<sample.size();i++)
        {
            System.out.println(sample.get(i).getBloodGroup() +" " + sample.get(i).getHospitalName() + " "
                    + sample.get(i).getDonorName() + " " + sample.get(i).getDonatedDateAndTime() + "\n");
        }

        return sample;
    }

    @GetMapping(path="/getLiverDonorInfo", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<DonorInfo> getLiverDonorInfo(final BldAndHospital bldAndHospital) {

        System.out.println("");
        System.out.println("inside SecUserDetailsController-getLiverDonorInfo ");
        System.out.println("all details: " + bldAndHospital.getBloodGroup()  + "   " + bldAndHospital.getHospitalName());
        System.out.println("\n\n check:--" + bldAndHospital.getBloodGroup()+"--");

        String bldGrp = bldAndHospital.getBloodGroup();

        if(bldAndHospital.getBloodGroup().equals("A ") || bldAndHospital.getBloodGroup().equals("B ") || bldAndHospital.getBloodGroup().equals("O ") || bldAndHospital.getBloodGroup().equals("AB "))
        {
            String[] bG = bldAndHospital.getBloodGroup().split(" ", 3);
            bldGrp = bG[0] + "+";
        }

        System.out.println("bldgrp = " + bldGrp);
        List<DonorInfo> sample = organServiceTwo.getDonorInfo("Liver", bldGrp, bldAndHospital.getHospitalName());

        System.out.println("\n\ninside SecUserDetailsController-getDonorInfo\n\n");

        for(int i=0;i<sample.size();i++)
        {
            System.out.println(sample.get(i).getBloodGroup() +" " + sample.get(i).getHospitalName() + " "
                    + sample.get(i).getDonorName() + " " + sample.get(i).getDonatedDateAndTime() + "\n");
        }

        return sample;
    }

    @GetMapping(path="/getEyesDonorInfo", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<DonorInfo> getEyesDonorInfo(final BldAndHospital bldAndHospital) {

        System.out.println("");
        System.out.println("inside SecUserDetailsController-getEyesDonorInfo ");
        System.out.println("all details: " + bldAndHospital.getBloodGroup()  + "   " + bldAndHospital.getHospitalName());
        System.out.println("\n\n check:--" + bldAndHospital.getBloodGroup()+"--");

        String bldGrp = bldAndHospital.getBloodGroup();

        if(bldAndHospital.getBloodGroup().equals("A ") || bldAndHospital.getBloodGroup().equals("B ") || bldAndHospital.getBloodGroup().equals("O ") || bldAndHospital.getBloodGroup().equals("AB "))
        {
            String[] bG = bldAndHospital.getBloodGroup().split(" ", 3);
            bldGrp = bG[0] + "+";
        }

        System.out.println("bldgrp = " + bldGrp);
        List<DonorInfo> sample = organServiceTwo.getDonorInfo("Eyes", bldGrp, bldAndHospital.getHospitalName());

        System.out.println("\n\ninside SecUserDetailsController-getDonorInfo\n\n");

        for(int i=0;i<sample.size();i++)
        {
            System.out.println(sample.get(i).getBloodGroup() +" " + sample.get(i).getHospitalName() + " "
                    + sample.get(i).getDonorName() + " " + sample.get(i).getDonatedDateAndTime() + "\n");
        }

        return sample;
    }


    @GetMapping(path="/getKidneyOrgan", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<Organ> sendKidneyDetails() {

        System.out.println("inside: OrganController:sendKidneytDetails\n");
        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        List<Organ> kidneys = organServiceTwo.getOrgnData("Kidney");

        System.out.println("\ncoming out of : OrganController:sendKidneyDetails\n");

        //return temph;
        return kidneys;
    }

    @GetMapping(path="/getLiverOrgan", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<Organ> sendLiverDetails() {

        System.out.println("inside: OrganController:sendLiverDetails\n");
        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        List<Organ> livers = organServiceTwo.getOrgnData("Liver");

        System.out.println("\ncoming out of : OrganController:sendLiverDetails\n");

        //return temph;
        return livers;
    }

    @GetMapping(path="/getEyesOrgan", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<Organ> sendEyesDetails() {

        System.out.println("inside: OrganController:sendEyesDetails\n");
        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        List<Organ> eyes = organServiceTwo.getOrgnData("Eyes");

        System.out.println("\ncoming out of : OrganController:sendEyesDetails\n");

        //return temph;
        return eyes;
    }
}
