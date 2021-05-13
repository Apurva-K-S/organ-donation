package com.example.iiitb.OrganDonation.Controller;


import com.example.iiitb.OrganDonation.Beans.*;
import com.example.iiitb.OrganDonation.Services.OrganServiceTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path="/api")
public class OrganController {

    private OrganServiceTwo organServiceTwo;
    private static final Logger logger = LoggerFactory.getLogger(OrganController.class);
    //private static final Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    public OrganController(OrganServiceTwo organServiceTwo )
    {
        logger.info("[INFO]: inside OrganController()");
        this.organServiceTwo = organServiceTwo;
    }

    @GetMapping(path="/getHeartOrgan", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<Organ> sendHeartDetails() {

        System.out.println("inside: OrganController:sendHeartDetails\n");
        logger.info("[INFO]: OrganController:sendHeartDetails()");
        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        List<Organ> hearts = organServiceTwo.getOrgnData("Heart");
        logger.info("[INFO]: output of organServiceTwo.getOrgnData(\"Heart\"); = " + hearts.size());

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

        logger.info("[INFO]: inside SecUserDetailsController-getDonorInfo()");

        String bldGrp = bldAndHospital.getBloodGroup();

        if(bldAndHospital.getBloodGroup().equals("A ") || bldAndHospital.getBloodGroup().equals("B ") || bldAndHospital.getBloodGroup().equals("O ") || bldAndHospital.getBloodGroup().equals("AB "))
        {
            String[] bG = bldAndHospital.getBloodGroup().split(" ", 3);
            bldGrp = bG[0] + "+";
        }

        System.out.println("bldgrp = " + bldGrp);
        logger.info("[INFO]: bloodgroup is " + bldGrp);
        List<DonorInfo> sample = organServiceTwo.getDonorInfo("Heart", bldGrp, bldAndHospital.getHospitalName());
        logger.info("[INFO]: organServiceTwo.getDonorInfo(Heart, bldGrp, bldAndHospital.getHospitalName()); " + sample.size());

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

        logger.info("[INFO]: inside SecUserDetailsController-getKidneyDonorInfo()");
        String bldGrp = bldAndHospital.getBloodGroup();

        if(bldAndHospital.getBloodGroup().equals("A ") || bldAndHospital.getBloodGroup().equals("B ") || bldAndHospital.getBloodGroup().equals("O ") || bldAndHospital.getBloodGroup().equals("AB "))
        {
            String[] bG = bldAndHospital.getBloodGroup().split(" ", 3);
            bldGrp = bG[0] + "+";
        }

        System.out.println("bldgrp = " + bldGrp);
        logger.info("[INFO]: bloodgroup is " + bldGrp);

        List<DonorInfo> sample = organServiceTwo.getDonorInfo("Kidney", bldGrp, bldAndHospital.getHospitalName());

        System.out.println("\n\ninside SecUserDetailsController-getDonorInfo\n\n");
        logger.info("[INFO]: organServiceTwo.getDonorInfo(Kidney, bldGrp, bldAndHospital.getHospitalName()); " + sample.size());

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

        logger.info("[INFO]: inside SecUserDetailsController-getLiverDonorInfo()");

        String bldGrp = bldAndHospital.getBloodGroup();

        if(bldAndHospital.getBloodGroup().equals("A ") || bldAndHospital.getBloodGroup().equals("B ") || bldAndHospital.getBloodGroup().equals("O ") || bldAndHospital.getBloodGroup().equals("AB "))
        {
            String[] bG = bldAndHospital.getBloodGroup().split(" ", 3);
            bldGrp = bG[0] + "+";
        }

        System.out.println("bldgrp = " + bldGrp);
        logger.info("[INFO]: bloodgroup is " + bldGrp);

        List<DonorInfo> sample = organServiceTwo.getDonorInfo("Liver", bldGrp, bldAndHospital.getHospitalName());
        logger.info("[INFO]: organServiceTwo.getDonorInfo(Liver, bldGrp, bldAndHospital.getHospitalName()); " + sample.size());

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

        logger.info("[INFO]: inside SecUserDetailsController-getEyesDonorInfo()");

        String bldGrp = bldAndHospital.getBloodGroup();


        if(bldAndHospital.getBloodGroup().equals("A ") || bldAndHospital.getBloodGroup().equals("B ") || bldAndHospital.getBloodGroup().equals("O ") || bldAndHospital.getBloodGroup().equals("AB "))
        {
            String[] bG = bldAndHospital.getBloodGroup().split(" ", 3);
            bldGrp = bG[0] + "+";
        }

        System.out.println("bldgrp = " + bldGrp);
        logger.info("[INFO]: bloodgroup is " + bldGrp);

        List<DonorInfo> sample = organServiceTwo.getDonorInfo("Eyes", bldGrp, bldAndHospital.getHospitalName());
        logger.info("[INFO]: organServiceTwo.getDonorInfo(Eyes, bldGrp, bldAndHospital.getHospitalName()); " + sample.size());

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

        logger.info("[INFO]: inside OrganController:sendKidneytDetails");

        List<Organ> kidneys = organServiceTwo.getOrgnData("Kidney");
        logger.info("[INFO]: organServiceTwo.getOrgnData(Kidney); = " + kidneys.size());

        System.out.println("\ncoming out of : OrganController:sendKidneyDetails\n");

        //return temph;
        return kidneys;
    }

    @GetMapping(path="/getLiverOrgan", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<Organ> sendLiverDetails() {

        System.out.println("inside: OrganController:sendLiverDetails\n");
        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        logger.info("[INFO]: inside OrganController:sendLiverDetails");

        List<Organ> livers = organServiceTwo.getOrgnData("Liver");
        logger.info("[INFO]: organServiceTwo.getOrgnData(Liver); = " + livers.size());

        System.out.println("\ncoming out of : OrganController:sendLiverDetails\n");

        //return temph;
        return livers;
    }

    @GetMapping(path="/getEyesOrgan", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<Organ> sendEyesDetails() {

        System.out.println("inside: OrganController:sendEyesDetails\n");
        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        logger.info("[INFO]: inside OrganController:sendEyesDetails");

        List<Organ> eyes = organServiceTwo.getOrgnData("Eyes");
        logger.info("[INFO]: organServiceTwo.getOrgnData(Eyes); = " + eyes.size());

        System.out.println("\ncoming out of : OrganController:sendEyesDetails\n");

        //return temph;
        return eyes;
    }
}
