package com.example.iiitb.OrganDonation.Controller;

import com.example.iiitb.OrganDonation.Beans.PriUserOrganListDetails;
import com.example.iiitb.OrganDonation.Beans.SecUserDetails;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path="/api")
public class SecUserDetailsController {

    @GetMapping(path="/secUserGetList", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    //@GetMapping("/secUserGetList")
    public @ResponseBody
    Response getOrganTableController( final SecUserDetails secUserDetails) {

        System.out.println("inside SecUserDetailsController-getOrganTableController ");
        System.out.println("primary USer status: "+secUserDetails.getPriUserStatus());
        System.out.println("Email: "+secUserDetails.getLoginEmail());

        //boolean result=priUserOrganListService.storeOrganData(orgList);

        return Response.ok().build();
    }
}
