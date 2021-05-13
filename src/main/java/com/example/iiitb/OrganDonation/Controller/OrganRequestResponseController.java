package com.example.iiitb.OrganDonation.Controller;


import com.example.iiitb.OrganDonation.Beans.HospitalNames;
import com.example.iiitb.OrganDonation.Beans.Organ;
import com.example.iiitb.OrganDonation.Beans.OrganRequest;
import com.example.iiitb.OrganDonation.Beans.OrganResponse;
import com.example.iiitb.OrganDonation.Services.OrganRequestResponseService;
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

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping(path="/api")
public class OrganRequestResponseController {

    private OrganRequestResponseService organRequestResponseService;
    private OrganResponse orgResponse;
    private static final Logger logger = LoggerFactory.getLogger(OrganRequestResponseController.class);
    //private static final Logger logger = LogManager.getLogger(LoginController.class);
    List<OrganResponse> organsRequested;

    @Autowired
    public OrganRequestResponseController(OrganRequestResponseService organRequestResponseService, OrganResponse orgResponse)
    {
        logger.info("[INFO]: inside OrganRequestResponseController()");
        this.organRequestResponseService = organRequestResponseService;
        this.orgResponse = orgResponse;
    }


    @PostMapping(path="/organRequest", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Response raiseOrganRequest(@RequestBody final OrganRequest orgReq)
    {
        System.out.println("Inside raiseOrganRequest() of controller class");
        logger.info("[INFO]: inside raiseOrganRequest() of controller class");

         boolean result = organRequestResponseService.getOrganRequestDetails(orgReq);
         logger.info("[INFO]: organRequestResponseService.getOrganRequestDetails(orgReq); = " + result);

         if(result)
                return Response.ok().build();

         return Response.status(401).build();

    }

    @GetMapping(path="/getResponseData", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<OrganResponse> getResponseData(final HospitalNames hospitalName) {

        System.out.println("inside OrganRequestResponseController:getResponseData ");
        logger.info("[INFO]: inside OrganRequestResponseController:getResponseData ");

        System.out.println("hospitalname is: " + hospitalName.getHospitalName());
        List<OrganResponse> temp = organRequestResponseService.getResponseData(hospitalName.getHospitalName());
        logger.info("[INFO]: inside organRequestResponseService.getResponseData(hospitalName.getHospitalName()); =  " +temp.size());
        return temp;
    }


    @PostMapping(path="/sendDonationData", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Response sendDonationData(@RequestBody final OrganResponse organResponse)
    {
        System.out.println("Inside sendDonationData() of controller class");
        logger.info("[INFO]: inside OrganRequestResponseController:sendDonationData ");

        System.out.println("values are: " + organResponse.getDonorName() + " --- " + organResponse.getDonorEmail()
        + " --- " + organResponse.getRecepientName() + " --- " + organResponse.getDonorHospital() + " ---- "
                        + organResponse.getOrgan() + " ---- " + organResponse.getBloodGroup());

        boolean result = organRequestResponseService.deletingCorrespondingData(organResponse);
        logger.info("[INFO]: result of organRequestResponseService.deletingCorrespondingData(organResponse); = " + result );
        /*

        | request_response        |
        | user_final_organ_table  |

          donorName: any;
          donorEmail: any;
          recepientName: any;
          donorHospital: any;
          requestHospitalEmail: any;
          organ: any;
          bloodGroup: any;

        boolean result = organRequestResponseService.getOrganRequestDetails(orgReq);

        if(result)*/
        if(result)
            return Response.ok().build();
        return Response.status(401).build();

        //return Response.status(401).build();

    }

}
