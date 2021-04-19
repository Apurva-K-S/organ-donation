package com.example.iiitb.OrganDonation.Controller;

import com.example.iiitb.OrganDonation.Beans.LoginDetails;
import com.example.iiitb.OrganDonation.Beans.PriUserOrganListDetails;
import com.example.iiitb.OrganDonation.Services.LoginService;
import com.example.iiitb.OrganDonation.Services.PriUserOrganListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

@RestController
@RequestMapping(path="/api")
public class PriUserOrganListController {

    private PriUserOrganListService priUserOrganListService;


    @Autowired
    public PriUserOrganListController(PriUserOrganListService priUserOrganListService)
    {
        this.priUserOrganListService=priUserOrganListService;
    }


    @PostMapping(path="/primUserOrganList", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Response takeOrganList(@RequestBody final PriUserOrganListDetails orgList) {

        System.out.println("inside PriUserOrganListController-takeOrganList ");
        System.out.println("Heart: "+orgList.getOrgan_Heart());
        System.out.println("Kidney: "+orgList.getOrgan_Kidney());
        //System.out.println("Lungs: "+orgList.getOrgan_Lungs());
        //System.out.println("Liver: "+orgList.getOrgan_Liver());
        //System.out.println("Eyes: "+orgList.getOrgan_Eyes());
        //System.out.println("Skin: "+orgList.getOrgan_Skin());
        System.out.println("email: "+orgList.getLoginEmail());

        boolean result=priUserOrganListService.storeOrganData(orgList);

        return Response.ok().build();
    }
}
