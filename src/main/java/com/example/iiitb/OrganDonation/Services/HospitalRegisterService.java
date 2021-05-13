package com.example.iiitb.OrganDonation.Services;

import com.example.iiitb.OrganDonation.Beans.HospitalNames;
import com.example.iiitb.OrganDonation.Beans.HospitalRegistration;
import com.example.iiitb.OrganDonation.Beans.primaryUser;
import com.example.iiitb.OrganDonation.Controller.LoginController;
import com.example.iiitb.OrganDonation.Controller.SecUserDetailsController;
import com.example.iiitb.OrganDonation.DAO.HospitalRegisterRepository;
import com.example.iiitb.OrganDonation.DAO.primaryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.ArrayList;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Named
@Slf4j
public class HospitalRegisterService {

    HospitalRegisterRepository hospitalRegisterRepository ;
    private static final Logger logger = LoggerFactory.getLogger(HospitalRegisterService.class);
    //private static final Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    public HospitalRegisterService(HospitalRegisterRepository hospitalRegisterRepository)
    {
        logger.info("[INFO]: inside HospitalRegisterService()");
        this.hospitalRegisterRepository = hospitalRegisterRepository;
    }

    public boolean registerHospital(HospitalRegistration hospitalRegistration)
    {
        System.out.println("inside HospitalRegisterService:registerHospital");
        logger.info("[INFO]: inside HospitalRegisterService:registerHospital");

        HospitalRegistration hR = new HospitalRegistration();
        hR.setCity(hospitalRegistration.getCity());
        hR.setHospEmail(hospitalRegistration.getHospEmail());
        hR.setHospName(hospitalRegistration.getHospName());
        hR.setPassword(hospitalRegistration.getPassword());
        hR.setPhone(hospitalRegistration.getPhone());
        hR.setPin(hospitalRegistration.getPin());
        hR.setState(hospitalRegistration.getState());

        HospitalRegistration hrTemp = hospitalRegisterRepository.save(hR);

        logger.info("[INFO]: result of hospitalRegisterRepository.save(hR); = " + hrTemp );
        if(hrTemp == null)
            return false;
        return true;

    }

    public List<HospitalNames> getHospitalData()
    {
        System.out.println("inside HospitalRegisterService:getHospitalData");
        logger.info("[INFO]: inside HospitalRegisterService:getHospitalData");

        List<Object[]> h = hospitalRegisterRepository.findByHospName();
        List<HospitalNames> hNames = new ArrayList<>();
        System.out.println("lets checkout the list of hospitalNames: ");

        for(int i=0;i<h.size();i++)
        {
            HospitalNames hN = new HospitalNames();
            System.out.println(h.get(i)[0]);
            hN.setHospitalName(h.get(i)[0].toString());
            hNames.add(hN);
        }
        logger.info("[INFO]: size of result of output names is = " + hNames.size());
        return hNames;
    }

    public List<HospitalRegistration> getHospitalAllData()
    {
        System.out.println("inside HospitalRegisterService:getHospitalAllData");
        logger.info("[INFO]: inside HospitalRegisterService:getHospitalAllData()");
        List<HospitalRegistration> hospitalData = hospitalRegisterRepository.findAll();
        logger.info("[INFO]: size of result of output names is = " + hospitalData.size());
        return hospitalData;
    }

    public String authenticateHospital(String email, String password)
    {
        logger.info("[INFO]: inside HospitalRegisterService:authenticateHospital()");
        List<HospitalRegistration> temp = hospitalRegisterRepository.findByHospEmailAndPassword(email, password);

        logger.info("[INFO]: hospitalRegisterRepository.findByHospEmailAndPassword(email, password); = " + temp.size());

        if(temp.size() != 0)
            return temp.get(0).getHospName();
        return null;
    }
}
