package com.example.iiitb.OrganDonation.Services;

import com.example.iiitb.OrganDonation.DAO.OrganRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class OrganService {
    OrganRepository organRepository;

    @Autowired
    public OrganService(OrganRepository organRepository)
    {
        this.organRepository = organRepository;
    }

    public List<List<Object[]>>  getOrganData(String orgn)
    {
        System.out.println("inside: OrganService: getOrganData()");
        List<Object[]> t = new ArrayList<Object[]>();
        t = organRepository.findByOrgan(orgn);

        System.out.println("size of output returned by OrganRepository.findByOrgan("+ orgn +"); is " + t.size());

        System.out.println("----------------------------------------------------------------------------------------------");

        System.out.println("The output of " +
                "select pu.first_name, oht.hospital_name, ou.organ, pu.blood_group, oht.datetime from primary_user pu, organ_user_table ou, user_hospital_table oht\n" +
                "where pu.email = ou.user_email and pu.email = oht.user_email and\n" +
                "(oht.datetime, ou.organ, pu.blood_group) in (select min(oht.datetime), ou.organ, pu.blood_group from primary_user pu, organ_user_table ou, user_hospital_table oht\n" +
                "where pu.email = ou.user_email and pu.email = oht.user_email group by ou.organ, pu.blood_group) and ou.organ=" + orgn +" is: \n");

        for(int i=0;i<t.size();i++)
        {
            for(int j=0;j<t.get(i).length;j++)
            {
                System.out.print(t.get(i)[j] + "  ");
            }
            System.out.println("");
        }

        System.out.println("----------------------------------------------------------------------------------------------");

        System.out.println("The output of select ou.organ, pu.blood_group, count(*), min(uht.datetime) from primary_user pu, organ_user_table ou, user_hospital_table uht where pu.email = ou.user_email\n" +
                "and uht.user_email = pu.email and ou.organ=" + orgn +" group by ou.organ, pu.blood_group; is: ");
        List<Object[]> temp = organRepository.findByOrganContaining(orgn);
        for(int i=0;i<temp.size();i++)
        {
            for(int j=0;j<temp.get(i).length;j++)
            {
                System.out.print(temp.get(i)[j] + "  ");
            }
            System.out.println("");
        }

        List<List<Object[]>> organsData = new ArrayList<>();

        organsData.add(t);
        organsData.add(temp);

        return organsData;
    }

}
