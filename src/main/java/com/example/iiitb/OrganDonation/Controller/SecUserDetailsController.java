package com.example.iiitb.OrganDonation.Controller;

import com.example.iiitb.OrganDonation.Beans.*;
import com.example.iiitb.OrganDonation.Services.LoginService;
import com.example.iiitb.OrganDonation.Services.SecUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.Json;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path="/api")
public class SecUserDetailsController {

    private SecUserDetailsService secUserDetailsService;
    private static final Logger logger = LoggerFactory.getLogger(SecUserDetailsController.class);
    //private static final Logger logger = LogManager.getLogger(LoginController.class);


    @Autowired
    public SecUserDetailsController(SecUserDetailsService secUserDetailsService)
    {
        logger.info("[INFO]: inside SecUserDetailsController()");
        this.secUserDetailsService=secUserDetailsService;
    }

    @GetMapping(path="/secUserGetList", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    //@GetMapping("/secUserGetList")
    public @ResponseBody
    List<JustOrgansList> getOrganTableController( final SecUserDetails secUserDetails) {

        System.out.println("");
        System.out.println("inside SecUserDetailsController-getOrganTableController ");
        logger.info("[INFO]: inside SecUserDetailsController-getOrganTableController()");

        System.out.println("primary USer status: "+secUserDetails.getPriUserStatus());
        System.out.println("Email: "+secUserDetails.getLoginEmail());
        logger.info("[INFO]: primary USer status: "+secUserDetails.getPriUserStatus() + "Email: "+secUserDetails.getLoginEmail());

        List<userOrganTable> organs = secUserDetailsService.getOrgansList(secUserDetails.getLoginEmail());

        System.out.println("size of result list is: " + organs.size());
        logger.info("[INFO]: size of result list is: " + organs.size());

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
        logger.info("[INFO]: size of listOfOrgans: " + listOfOrgans.size());
        return listOfOrgans;
    }

    @PostMapping(path="/storeHospitalName", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Response userAuthentication(@RequestBody final Map<String, Object> allDetails)
    {
        System.out.println("\nSecUserDetailsController:userAuthentication api:storeHospitalName");
        logger.info("[INFO]: SecUserDetailsController:userAuthentication api:storeHospitalName");

        System.out.println("all details: " + allDetails);
        System.out.println("primary User Status is: " + allDetails.get("priUserStatus"));
        System.out.println("hospital name is: " + allDetails.get("hospitalName"));
        System.out.println("login Email is: " + allDetails.get("loginEmail")); // this email is secondary_email.
        logger.info("[INFO]: all details: " + allDetails);

        System.out.println("check the keys:\n");
        Iterator<Map.Entry<String, Object>> iterator = allDetails.entrySet().iterator();

        List<String> organsList = new ArrayList<String>();

        // Iterate over the HashMap
        while (iterator.hasNext()) {
            // Get the entry at this iteration
            Map.Entry<String, Object> entry = iterator.next();

            // Check if this key is the required key
            if ("Heart" == entry.getKey()) {
                System.out.println(allDetails.get("Heart"));
                if(allDetails.get("Heart").toString()=="true")
                    organsList.add(entry.getKey());
            }
            if("Eyes" == entry.getKey()){
                System.out.println(allDetails.get("Eyes"));
                if(allDetails.get("Eyes").toString()=="true")
                    organsList.add(entry.getKey());
            }
            if("Liver" == entry.getKey()){
                System.out.println(allDetails.get("Liver"));
                if(allDetails.get("Liver").toString()=="true")
                    organsList.add(entry.getKey());
            }
            if("Kidney" == entry.getKey()) {
                System.out.println(allDetails.get("Kidney"));
                if(allDetails.get("Kidney").toString()=="true")
                    organsList.add(entry.getKey());
            }
        }

        boolean result1 = secUserDetailsService.storeUserFinalOrgans(organsList, allDetails.get("loginEmail").toString());

        boolean result = secUserDetailsService.storeHospitalName( allDetails.get("hospitalName").toString(), allDetails.get("loginEmail").toString());

        logger.info("[INFO]: result1 of secUserDetailsService.storeUserFinalOrgans(organsList, allDetails.get(loginEmail).toString());" + result1 );
        logger.info("[INFO]: result of secUserDetailsService.storeHospitalName( allDetails.get(hospitalName).toString(), allDetails.get(loginEmail).toString());" + result);
        System.out.println("\nResult is " + result1);

        if(result && result1)
            return Response.ok().build();

        return Response.status(401).build();
    }
}
