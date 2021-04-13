package com.example.iiitb.OrganDonation.Services;

import com.example.iiitb.OrganDonation.Beans.UserHospitalTable;
import com.example.iiitb.OrganDonation.Beans.primaryUser;
import com.example.iiitb.OrganDonation.Beans.userOrganTable;
import com.example.iiitb.OrganDonation.DAO.LoginRepository;
import com.example.iiitb.OrganDonation.DAO.PriUserOrganListRepository;
import com.example.iiitb.OrganDonation.DAO.SecUserDetailsRepository;
import com.example.iiitb.OrganDonation.DAO.StoreHospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;

import javax.inject.Named;
import java.sql.Date;
import java.util.List;

@Named
public class SecUserDetailsService {


    SecUserDetailsRepository secUserDetailsRepository;
    PriUserOrganListRepository priUserOrganListRepository ;
    LoginRepository loginRepository;
    StoreHospitalRepository storeHospitalRepository;

    private SendEmailService sendEmailService;

    @Autowired
    public SecUserDetailsService(SecUserDetailsRepository secUserDetailsRepository, LoginRepository loginRepository, PriUserOrganListRepository priUserOrganListRepository, StoreHospitalRepository storeHospitalRepository, SendEmailService sendEmailService)
    {
        this.secUserDetailsRepository = secUserDetailsRepository;
        this.loginRepository = loginRepository;
        this.priUserOrganListRepository = priUserOrganListRepository;
        this.storeHospitalRepository = storeHospitalRepository;
        this.sendEmailService = sendEmailService;
    }

    public List<userOrganTable> getOrgansList(String loginEmail)
    {
        System.out.println("");
        System.out.println("inside SecUserDetailsService-getOrgansList ");
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

    public boolean storeHospitalName(String hospitalName, String loginEmail)
    {
        System.out.println("\nSecUserDetailsController -> SecUserDetailsService:storeHospitalName");
        List<primaryUser> pu = loginRepository.findBySecondary_email(loginEmail);

        UserHospitalTable userHospitalTable = new UserHospitalTable();

        userHospitalTable.setHospitalName(hospitalName);
        userHospitalTable.setPuser(pu.get(0));


        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());

        userHospitalTable.setDatetime(date);
        System.out.println("current date time is: " + date);

        UserHospitalTable uHT = storeHospitalRepository.save(userHospitalTable);

        String msg = "Sorry for your demise.\n Your organs have been donated to " + hospitalName + " \n. You have lightened many lives today.\n\nMay your soul rest in peace.";
        sendEmailService.sendEmail(pu.get(0).getEmail(), "from OrganDonantion", msg);

        if(uHT == null)
            return false;
        return true;
    }
}
