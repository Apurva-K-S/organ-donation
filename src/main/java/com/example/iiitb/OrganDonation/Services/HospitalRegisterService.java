package com.example.iiitb.OrganDonation.Services;

import com.example.iiitb.OrganDonation.Beans.HospitalNames;
import com.example.iiitb.OrganDonation.Beans.HospitalRegistration;
import com.example.iiitb.OrganDonation.Beans.primaryUser;
import com.example.iiitb.OrganDonation.DAO.HospitalRegisterRepository;
import com.example.iiitb.OrganDonation.DAO.primaryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class HospitalRegisterService {

    HospitalRegisterRepository hospitalRegisterRepository ;

    @Autowired
    public HospitalRegisterService(HospitalRegisterRepository hospitalRegisterRepository)
    {
        this.hospitalRegisterRepository = hospitalRegisterRepository;
    }

    public boolean registerHospital(HospitalRegistration hospitalRegistration)
    {
        System.out.println("inside HospitalRegisterService:registerHospital");
        HospitalRegistration hR = new HospitalRegistration();
        hR.setCity(hospitalRegistration.getCity());
        hR.setHospEmail(hospitalRegistration.getHospEmail());
        hR.setHospName(hospitalRegistration.getHospName());
        hR.setPassword(hospitalRegistration.getPassword());
        hR.setPhone(hospitalRegistration.getPhone());
        hR.setPin(hospitalRegistration.getPin());
        hR.setState(hospitalRegistration.getState());

        HospitalRegistration hrTemp = hospitalRegisterRepository.save(hR);

        if(hrTemp == null)
            return false;
        return true;

    }

    public List<HospitalNames> getHospitalData()
    {
        System.out.println("inside HospitalRegisterService:getHospitalData");
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

        return hNames;
    }

    public List<HospitalRegistration> getHospitalAllData()
    {
        System.out.println("inside HospitalRegisterService:getHospitalAllData");
        List<HospitalRegistration> hospitalData = hospitalRegisterRepository.findAll();
        return hospitalData;
    }

    public boolean authenticateHospital(String email, String password)
    {
        List<HospitalRegistration> temp = hospitalRegisterRepository.findByHospEmailAndPassword(email, password);

        if(temp.size() != 0)
            return true;
        return false;
    }
}
