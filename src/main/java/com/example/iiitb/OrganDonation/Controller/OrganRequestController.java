package com.example.iiitb.OrganDonation.Controller;


import com.example.iiitb.OrganDonation.Beans.HospitalRegistration;
import com.example.iiitb.OrganDonation.Beans.OrganRequest;
import com.example.iiitb.OrganDonation.Beans.OrganResponse;
import com.example.iiitb.OrganDonation.Services.OrganRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping(path="/api")
public class OrganRequestController {

    private OrganRequestService organRequestService;
    private OrganResponse orgResponse;
    List<OrganResponse> organsRequested;

    @Autowired
    public OrganRequestController(OrganRequestService organRequestService, OrganResponse orgResponse)
    {
        this.organRequestService = organRequestService;
        this.orgResponse = orgResponse;
    }


    @PostMapping(path="/organRequest", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Response raiseOrganRequest(@RequestBody final OrganRequest orgReq)
    {
        System.out.println("Inside raiseOrganRequest() of controller class");

         organsRequested = organRequestService.getOrganRequestDetails(orgReq);

         if(organsRequested.size()==0)
                return Response.status(401).build();

         return Response.ok().build();

    }

}
