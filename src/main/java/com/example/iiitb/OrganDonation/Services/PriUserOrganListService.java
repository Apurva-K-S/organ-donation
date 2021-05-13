package com.example.iiitb.OrganDonation.Services;

import com.example.iiitb.OrganDonation.Beans.PriUserOrganListDetails;
import com.example.iiitb.OrganDonation.Beans.primaryUser;
import com.example.iiitb.OrganDonation.Beans.userOrganTable;
import com.example.iiitb.OrganDonation.Controller.LoginController;
import com.example.iiitb.OrganDonation.DAO.LoginRepository;
import com.example.iiitb.OrganDonation.DAO.PriUserOrganListRepository;
import com.example.iiitb.OrganDonation.DAO.primaryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@Slf4j
public class PriUserOrganListService {

    PriUserOrganListRepository priUserOrganListRepository;
    LoginRepository loginRepository;
    private static final Logger logger = LoggerFactory.getLogger(PriUserOrganListService.class);
    //private static final Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    public PriUserOrganListService(PriUserOrganListRepository priUserOrganListRepository, LoginRepository loginRepository)
    {
        logger.info("[INFO]: inside PriUserOrganListService()");
        this.priUserOrganListRepository = priUserOrganListRepository;
        this.loginRepository = loginRepository;
    }

    public boolean storeOrganData(PriUserOrganListDetails orgList)
    {

        System.out.println("inside PriUserOrganListService-storeOrganData ");
        logger.info("[INFO]: inside PriUserOrganListService-storeOrganData()");

        List<String> temp=new ArrayList<>();

        if(orgList.getOrgan_Eyes()=="true")
            temp.add("Eyes");
        if(orgList.getOrgan_Liver() == "true")
            temp.add("Liver");
        if(orgList.getOrgan_Kidney() == "true")
            temp.add("Kidney");
        if(orgList.getOrgan_Heart() == "true")
            temp.add("Heart");

        System.out.println("total number of organs: " + temp.size());
        logger.info("[INFO] total number of organs: " + temp.size());

        System.out.println("organs are: ");
        for(int i=0;i<temp.size();i++)
        {
            System.out.println(temp.get(i));
        }

        userOrganTable t;

        List<primaryUser> l= loginRepository.findByEmail(orgList.getLoginEmail());
        primaryUser p = l.get(0);

        for(int i=0;i<temp.size();i++)
        {
            System.out.println(temp.get(i));
            userOrganTable u = new userOrganTable();
            u.setOrgan(temp.get(i));
            u.setPuser(p);
            t = priUserOrganListRepository.save(u);
            System.out.println("value returned after saving: " + t);
            p = l.get(0);
        }

        return true;
    }
}
