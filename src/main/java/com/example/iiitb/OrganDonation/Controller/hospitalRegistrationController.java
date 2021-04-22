package com.example.iiitb.OrganDonation.Controller;

import com.example.iiitb.OrganDonation.Beans.*;
import com.example.iiitb.OrganDonation.Services.HospitalRegisterService;
import com.example.iiitb.OrganDonation.Services.RegisterService;
import com.example.iiitb.OrganDonation.Services.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/api")
public class hospitalRegistrationController
{

    private HospitalRegisterService hospitalRegisterService;
    private SendEmailService sendEmailService;


    @Autowired
    public hospitalRegistrationController(HospitalRegisterService hospitalRegisterService, SendEmailService sendEmailService)
    {
        this.hospitalRegisterService = hospitalRegisterService;
        this.sendEmailService = sendEmailService;
    }

    @PostMapping(path="/hospitalRegistration", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Response addHospitalData(@RequestBody final HospitalRegistration hospitalRegistration)
    {
        System.out.println("Inside addHospitalData");
        System.out.println(hospitalRegistration.getHospName() + " " + hospitalRegistration.getHospEmail() + "  " + hospitalRegistration.getPhone()
        + "  " + hospitalRegistration.getCity() + "  " + hospitalRegistration.getState() + "  " + hospitalRegistration.getPassword() + "  " + hospitalRegistration.getPin());

        boolean result=hospitalRegisterService.registerHospital(hospitalRegistration);

        String msg = "You have been registered successfully.\n Your password is: " + hospitalRegistration.getPassword();
        sendEmailService.sendEmail(hospitalRegistration.getHospEmail(), "from OrganDonantion", msg);

        if(result == false)
            return Response.status(401).build();

        return Response.ok().build();
    }

    @GetMapping(path="/thankyou", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<HospitalNames> getHospitalsList() {

        System.out.println("inside: hospitalRegistrationController:getHospitalsList\n");
        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        List<HospitalNames> hNames = hospitalRegisterService.getHospitalData();

        System.out.println("\ncoming out of : HospitalRegistrationController:getHospitalsList\n");
        System.out.println("\nSize of hNames: "+hNames.size());

        for(int i=0;i<hNames.size();i++) {

            System.out.println("hNames data is: " + hNames.get(i).getHospitalName());
        }

        return hNames;
    }

    @GetMapping(path="/getAllHospitalsData", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<HospitalRegistration> getAllHospitalData() {

        System.out.println("inside: hospitalRegistrationController:getAllHospitalData\n");
        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        List<HospitalRegistration> hNames = hospitalRegisterService.getHospitalAllData();

        System.out.println("\ncoming out of : HospitalRegistrationController:getAllHospitalData\n");

        return hNames;
    }

    @PostMapping(path="/hospitalLogin", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Response hospitalAuthentication(@RequestBody final Map<String, Object> loginDetails)
    {
        System.out.println("inside hospitalRegistrationController:hospitalAuthentication");
        System.out.println(loginDetails);
        //loginEmail && loginPassword
        boolean result = hospitalRegisterService.authenticateHospital(loginDetails.get("loginEmail").toString(), loginDetails.get("loginPassword").toString());

        System.out.println(result);
        if(result)
            return Response.ok().build();

        return Response.status(401).build();
    }
}
