package com.example.iiitb.OrganDonation.Controller;

import com.example.iiitb.OrganDonation.Beans.*;
import com.example.iiitb.OrganDonation.Services.HospitalRegisterService;
import com.example.iiitb.OrganDonation.Services.RegisterService;
import com.example.iiitb.OrganDonation.Services.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping(path="/api")
public class hospitalRegistrationController
{

    private HospitalRegisterService hospitalRegisterService;
    private SendEmailService sendEmailService;
    private static final Logger logger = LoggerFactory.getLogger(hospitalRegistrationController.class);
    //private static final Logger logger = LogManager.getLogger(LoginController.class);


    @Autowired
    public hospitalRegistrationController(HospitalRegisterService hospitalRegisterService, SendEmailService sendEmailService)
    {
        logger.info("[INFO]: inside hospitalRegistrationController()");
        this.hospitalRegisterService = hospitalRegisterService;
        this.sendEmailService = sendEmailService;
    }

    @PostMapping(path="/hospitalRegistration", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Response addHospitalData(@RequestBody final HospitalRegistration hospitalRegistration)
    {
        System.out.println("Inside addHospitalData");
        logger.info("[INFO]: inside hospitalRegistrationController:addHospitalData()");

        System.out.println(hospitalRegistration.getHospName() + " " + hospitalRegistration.getHospEmail() + "  " + hospitalRegistration.getPhone()
        + "  " + hospitalRegistration.getCity() + "  " + hospitalRegistration.getState() + "  " + hospitalRegistration.getPassword() + "  " + hospitalRegistration.getPin());

        boolean result=hospitalRegisterService.registerHospital(hospitalRegistration);
        logger.info("[INFO]: result of hospitalRegisterService.registerHospital(hospitalRegistration) = " + result);

        String msg = "You have been registered successfully.\n Your password is: " + hospitalRegistration.getPassword();
        sendEmailService.sendEmail(hospitalRegistration.getHospEmail(), "from OrganDonantion", msg);

        if(result == false)
            return Response.status(401).build();

        return Response.ok().build();
    }

    @GetMapping(path="/thankyou", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<HospitalNames> getHospitalsList() {

        System.out.println("inside: hospitalRegistrationController:getHospitalsList\n");
        logger.info("[INFO]: inside hospitalRegistrationController:getHospitalsList()");

        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        List<HospitalNames> hNames = hospitalRegisterService.getHospitalData();

        System.out.println("\ncoming out of : HospitalRegistrationController:getHospitalsList\n");
        System.out.println("\nSize of hNames: "+hNames.size());
        logger.info("[INFO]: Size of hNames: " + hNames.size());

        for(int i=0;i<hNames.size();i++) {

            System.out.println("hNames data is: " + hNames.get(i).getHospitalName());
        }

        return hNames;
    }

    @GetMapping(path="/getAllHospitalsData", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<HospitalRegistration> getAllHospitalData() {

        System.out.println("inside: hospitalRegistrationController:getAllHospitalData\n");
        logger.info("[INFO]: inside hospitalRegistrationController:getAllHospitalData()");

        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        List<HospitalRegistration> hNames = hospitalRegisterService.getHospitalAllData();

        System.out.println("\ncoming out of : HospitalRegistrationController:getAllHospitalData\n");
        logger.info("[INFO]: size of result of hospitalRegisterService.getHospitalAllData() =  " + hNames.size());

        return hNames;
    }

   // @GetMapping(path="/hospitalLogin", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.TEXT_PLAIN_VALUE})
    @PostMapping(path="/hospitalLogin", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    String hospitalAuthentication( @RequestBody final HospitalLoginDetails loginDetails)
    {
        System.out.println("inside hospitalRegistrationController:hospitalAuthentication");
        System.out.println("Email: "+loginDetails.getloginEmail());
        System.out.println("Password: "+loginDetails.getloginPassword());
        logger.info("[INFO]: inside hospitalRegistrationController:hospitalAuthentication() with details = "
                +loginDetails.getloginEmail() + " -- " + loginDetails.getloginPassword());
        //loginEmail && loginPassword
        String result = hospitalRegisterService.authenticateHospital(loginDetails.getloginEmail(), loginDetails.getloginPassword());
        System.out.println("Result: "+result);
        logger.info("[INFO]: result of hospitalRegisterService.authenticateHospital(loginDetails.getloginEmail(), loginDetails.getloginPassword()) = " + result);

        if(result == null)
            return "Incorrect Credentials";

        return result;
    }
}
