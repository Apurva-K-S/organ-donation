package com.example.iiitb.OrganDonation.Services;

import com.example.iiitb.OrganDonation.Beans.UserHospitalTable;
import com.example.iiitb.OrganDonation.Beans.primaryUser;
import com.example.iiitb.OrganDonation.Beans.userFinalOrganTable;
import com.example.iiitb.OrganDonation.Beans.userOrganTable;
import com.example.iiitb.OrganDonation.Controller.LoginController;
import com.example.iiitb.OrganDonation.DAO.LoginRepository;
import com.example.iiitb.OrganDonation.DAO.PriUserOrganListRepository;
import com.example.iiitb.OrganDonation.DAO.UserFinalOrganTableRepository;
import com.example.iiitb.OrganDonation.DAO.SecUserDetailsRepository;
import com.example.iiitb.OrganDonation.DAO.StoreHospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import java.sql.Date;
import java.util.List;

@Named
@Slf4j
public class SecUserDetailsService {


    SecUserDetailsRepository secUserDetailsRepository;
    PriUserOrganListRepository priUserOrganListRepository ;
    LoginRepository loginRepository;
    StoreHospitalRepository storeHospitalRepository;
    UserFinalOrganTableRepository userFinalOrganTableRepository;
    private static final Logger logger = LoggerFactory.getLogger(SecUserDetailsService.class);
    //private static final Logger logger = LogManager.getLogger(LoginController.class);

    private SendEmailService sendEmailService;

    @Autowired
    public SecUserDetailsService(UserFinalOrganTableRepository userFinalOrganTableRepository,SecUserDetailsRepository secUserDetailsRepository, LoginRepository loginRepository, PriUserOrganListRepository priUserOrganListRepository, StoreHospitalRepository storeHospitalRepository, SendEmailService sendEmailService)
    {
        logger.info("[INFO]: inside SecUserDetailsService()");
        this.secUserDetailsRepository = secUserDetailsRepository;
        this.loginRepository = loginRepository;
        this.priUserOrganListRepository = priUserOrganListRepository;
        this.userFinalOrganTableRepository = userFinalOrganTableRepository;
        this.storeHospitalRepository = storeHospitalRepository;
        this.sendEmailService = sendEmailService;
    }

    public List<userOrganTable> getOrgansList(String loginEmail)
    {
        System.out.println("");
        System.out.println("inside SecUserDetailsService-getOrgansList");
        logger.info("[INFO]: SecUserDetailsService-getOrgansList");

        System.out.println("email is: " + loginEmail);

        List<primaryUser> pu = loginRepository.findBySecondary_email(loginEmail);
        String primaryEmail = pu.get(0).getEmail();
        System.out.println("secondary email is: " + loginEmail + " corresponding primaryEmail is: " + primaryEmail);
        List<userOrganTable> t = secUserDetailsRepository.findByPuserEmail(primaryEmail);

        System.out.println("size of result list is: " + t.size());

        for(int i=0;i<t.size();i++)
        {
            System.out.println("organ is: " + t.get(i).getOrgan());
            System.out.println("email id is: " + t.get(0).getPuser().getEmail());

        }
        System.out.println("at the end of SecUserDetailsService-getOrgansList");
        return t;
    }

    public boolean storeUserFinalOrgans(List<String> organsList, String loginEmail)
    {
        System.out.println("\nSecUserDetailsController -> SecUserDetailsService:storeUserFinalOrgans");
        System.out.println("\norganList size is: " + organsList.size());
        logger.info("[INFO]: SecUserDetailsController -> SecUserDetailsService:storeUserFinalOrgans");

        List<primaryUser> pu = loginRepository.findBySecondary_email(loginEmail);

        //List<primaryUser> l= loginRepository.findByEmail(orgList.getLoginEmail());
        primaryUser p = pu.get(0);
        userFinalOrganTable t;
        for(int i=0;i<organsList.size();i++)
        {
            System.out.println(organsList.get(i) + " ---- " + p.getEmail());

            userFinalOrganTable u = new userFinalOrganTable();
            u.setOrgan(organsList.get(i));
            u.setPuser(p);
            t = userFinalOrganTableRepository.save(u);
            System.out.println("value returned after saving: " + t);
            p = pu.get(0);
        }

        return true;
    }

    public boolean storeHospitalName(String hospitalName, String loginEmail)
    {
        System.out.println("\nSecUserDetailsController -> SecUserDetailsService:storeHospitalName");
        logger.info("[INFO] \nSecUserDetailsController -> SecUserDetailsService:storeHospitalName");
        List<primaryUser> pu = loginRepository.findBySecondary_email(loginEmail);

        UserHospitalTable userHospitalTable = new UserHospitalTable();

        userHospitalTable.setHospitalName(hospitalName);
        userHospitalTable.setPuser(pu.get(0));


        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());

        userHospitalTable.setDatetime(date);
        System.out.println("current date time is: " + date);
        logger.info("[INFO]: current date time is: " + date);

        UserHospitalTable uHT = storeHospitalRepository.save(userHospitalTable);

        String msg = "Sorry for your demise.\n Your organs have been donated to " + hospitalName + " \n. You have lightened many lives today.\n\nMay your soul rest in peace.";
        sendEmailService.sendEmail(pu.get(0).getEmail(), "from OrganDonantion", msg);

        //System.out.println(pu.get(0).getFirstName() + " : this is the first Name");

        String msgToHospital = pu.get(0).getFirstName() + " has donated organs to your hospital. Kindly check the information";

        System.out.println("the message to hospital is: " + msgToHospital);
        /*
        Steps here:
        1. u have hospital name.
        2. from that retrieve hospital email from hospital table.
        3. use that hospital email here as first parameter.
         */
//        sendEmailService.sendEmail("here u will get ", "from OrganDonantion", msg);

        if(uHT == null)
            return false;
        return true;
    }
}
