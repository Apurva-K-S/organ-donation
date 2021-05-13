package com.example.iiitb.OrganDonation.Controller;

import com.example.iiitb.OrganDonation.Beans.LoginDetails;
import com.example.iiitb.OrganDonation.Beans.PriUserOrganListDetails;
import com.example.iiitb.OrganDonation.Services.LoginService;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.iiitb.OrganDonation.Services.PriUserOrganListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

@RestController
@Slf4j
@RequestMapping(path="/api")
public class PriUserOrganListController {

    private PriUserOrganListService priUserOrganListService;
    private static final Logger logger = LoggerFactory.getLogger(PriUserOrganListController.class);
    //private static final Logger logger = LogManager.getLogger(LoginController.class);


    @Autowired
    public PriUserOrganListController(PriUserOrganListService priUserOrganListService)
    {
        logger.info("[INFO]: inside PriUserOrganListController()");
        this.priUserOrganListService=priUserOrganListService;
    }


    @PostMapping(path="/primUserOrganList", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Response takeOrganList(@RequestBody final PriUserOrganListDetails orgList) {

        System.out.println("inside PriUserOrganListController-takeOrganList ");
        logger.info("[INFO]: inside PriUserOrganListController-takeOrganList");
        System.out.println("Heart: "+orgList.getOrgan_Heart());
        System.out.println("Kidney: "+orgList.getOrgan_Kidney());
        System.out.println("email: "+orgList.getLoginEmail());

        boolean result=priUserOrganListService.storeOrganData(orgList);
        logger.info("[INFO]: result of priUserOrganListService.storeOrganData(orgList); = " + result);
        return Response.ok().build();
    }
}
