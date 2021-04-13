package com.example.iiitb.OrganDonation.Controller;

import com.example.iiitb.OrganDonation.Beans.*;
import com.example.iiitb.OrganDonation.Services.LoginService;
import com.example.iiitb.OrganDonation.Services.SecUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.json.Json;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path="/api")
public class SecUserDetailsController {

    private SecUserDetailsService secUserDetailsService;


    @Autowired
    public SecUserDetailsController(SecUserDetailsService secUserDetailsService)
    {
        this.secUserDetailsService=secUserDetailsService;
    }

    @GetMapping(path="/secUserGetList", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    //@GetMapping("/secUserGetList")
    public @ResponseBody
    List<JustOrgansList> getOrganTableController( final SecUserDetails secUserDetails) {

        System.out.println("");
        System.out.println("inside SecUserDetailsController-getOrganTableController ");
        System.out.println("primary USer status: "+secUserDetails.getPriUserStatus());
        System.out.println("Email: "+secUserDetails.getLoginEmail());

        List<userOrganTable> organs = secUserDetailsService.getOrgansList(secUserDetails.getLoginEmail());

        System.out.println("size of result list is: " + organs.size());


        for(int i=0;i<organs.size();i++)
        {
            System.out.println("organ is: " + organs.get(i).getOrgan());
            System.out.println("email id is: " + organs.get(0).getPuser().getEmail());
            System.out.println("");
        }
        System.out.println("at the end of SecUserDetailsController-getOrganTableController");

        //JustOrgansList justOrgansList;
        List<JustOrgansList> listOfOrgans=new ArrayList<JustOrgansList>();
        for(int i=0;i<organs.size();i++)
        {
            JustOrgansList justOrgansList=new JustOrgansList();
            justOrgansList.setOrgan(organs.get(i).getOrgan());
            listOfOrgans.add(justOrgansList);
        }
        System.out.println("size of listOfOrgans: " + listOfOrgans.size());
        return listOfOrgans;
    }

    @PostMapping(path="/storeHospitalName", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Response userAuthentication(@RequestBody final Map<String, Object> allDetails)
    {
        System.out.println("\nSecUserDetailsController:userAuthentication api:storeHospitalName");
        System.out.println("all details: " + allDetails);
        System.out.println("primary User Status is: " + allDetails.get("priUserStatus"));
        System.out.println("hospital name is: " + allDetails.get("hospitalName"));
        System.out.println("login Email is: " + allDetails.get("loginEmail")); // this email is secondary_email.

        boolean result = secUserDetailsService.storeHospitalName( allDetails.get("hospitalName").toString(), allDetails.get("loginEmail").toString());

        System.out.println("\nResult is " + result);
        if(result)
            return Response.ok().build();

        return Response.status(401).build();
    }
}
