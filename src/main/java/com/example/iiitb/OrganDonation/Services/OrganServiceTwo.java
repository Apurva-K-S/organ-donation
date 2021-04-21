package com.example.iiitb.OrganDonation.Services;

import com.example.iiitb.OrganDonation.Beans.DonorInfo;
import com.example.iiitb.OrganDonation.Beans.Organ;
import com.example.iiitb.OrganDonation.DAO.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class OrganServiceTwo {

    OrganRepository organRepository;
    OrganService organService;

    @Autowired
    public OrganServiceTwo(OrganRepository organRepository, OrganService organService)
    {
        this.organRepository = organRepository;
        this.organService = organService;
    }

    public List<Organ> getOrgnData(String orggn)
    {
        System.out.println("inside: OrganServiceTwo: getOrgnData()");
        /*List<Object[]> t = new ArrayList<Object[]>();
        t = organRepository.findByOrgan("Heart");

        System.out.println("size of output returned by heartRepository.findByOrgan(Heart); is " + t.size());

        System.out.println("----------------------------------------------------------------------------------------------");

        System.out.println("The output of " +
                "select pu.first_name, oht.hospital_name, ou.organ, pu.blood_group, oht.datetime from primary_user pu, organ_user_table ou, user_hospital_table oht\n" +
                "where pu.email = ou.user_email and pu.email = oht.user_email and\n" +
                "(oht.datetime, ou.organ, pu.blood_group) in (select min(oht.datetime), ou.organ, pu.blood_group from primary_user pu, organ_user_table ou, user_hospital_table oht\n" +
                "where pu.email = ou.user_email and pu.email = oht.user_email group by ou.organ, pu.blood_group) and ou.organ=\"Heart\" is: \n");

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
                "and uht.user_email = pu.email and ou.organ=\"Heart\" group by ou.organ, pu.blood_group; is: ");
        List<Object[]> temp = organRepository.findByOrganContaining("Heart");
        for(int i=0;i<temp.size();i++)
        {
            for(int j=0;j<temp.get(i).length;j++)
            {
                System.out.print(temp.get(i)[j] + "  ");
            }
            System.out.println("");
        }
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------------");


        we need : Blood Group	    Count	    Timer	        Donor Name	    Hospital Name
                   t[3]/temp[1]     temp[2]     t[4]/temp[3]    t[0]            t[1]*/

        List<List<Object[]>> listOflistOfOrgans = organService.getOrganData(orggn);
        List<Object[]> t = listOflistOfOrgans.get(0);
        List<Object[]> temp = listOflistOfOrgans.get(1);

        List<Organ> listOfOrgans =new ArrayList<Organ>();
        for(int i=0;i<t.size();i++)
        {
            Organ h = new Organ();
            h.setBloodGroup(t.get(i)[3].toString());
            h.setCount(temp.get(i)[2].toString());
            String timer = temp.get(i)[3].toString();
            String[] timr = timer.split(" ", 3);
            h.setDonatedDay(timr[0]);
            h.setDonatedTime(timr[1]);
            h.setDonorName(t.get(i)[0].toString());
            h.setHospitalName(t.get(i)[1].toString());

            listOfOrgans.add(h);
        }

        System.out.println("list of organs has been made... this is to check it");

        System.out.println("BloodGroup\t\tCount\t\tDonated Day \t\t Donated time\t\tDonorName\t\tHospitalName");

        for(int i = 0; i< listOfOrgans.size(); i++)
        {
            System.out.println(listOfOrgans.get(i).getBloodGroup()+"\t\t"+
                    listOfOrgans.get(i).getCount() + "\t\t" + listOfOrgans.get(i).getDonatedDay() + "\t\t" + listOfOrgans.get(i).getDonatedTime() + "\t\t" +
                            listOfOrgans.get(i).getDonorName() + "\t\t" + listOfOrgans.get(i).getHospitalName());
        }

        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------------");

        System.out.println("coming out of getOrgnData");
        //return t;
        return listOfOrgans;
    }

    public List<DonorInfo> getDonorInfo(String organ, String bldGrp, String hospitalName)
    {
        System.out.println("inside: OrganServiceTwo: getDonorInfo()");
        System.out.println(bldGrp + " ---- " + hospitalName);

        List<Object[]> result = new ArrayList<>();

        if(!hospitalName.equals("None") && !bldGrp.equals("None"))
        {
            result = organRepository.findByBothBldGrpAndHospital(organ, bldGrp, hospitalName);
        }
        else if(hospitalName.equals("None") && !bldGrp.equals("None")) // hospitalName is none
        {
            System.out.println("hospital name is none");
            result = organRepository.findByBldGrp(organ, bldGrp);
        }
        else if(!hospitalName.equals("None") && bldGrp.equals("None")) // bldGrp is none
        {
            System.out.println("Blood group name is none");
            result = organRepository.findByHospitalName(organ, hospitalName);
        }
        else
        {
            System.out.println("Both are none");
            result = organRepository.findByNeither(organ);
        }


        System.out.println("printing the result");

        //List<Object[]> result2 = new ArrayList<>();
        for(int i=0;i<result.size();i++)
        {
            for (int j = 0; j < result.get(i).length; j++)
            {
                System.out.print(result.get(i)[j] + "  ");
                System.out.print(result.get(i)[j].toString() + "\n");

            }
            System.out.println("");
        }

        List<DonorInfo> di = new ArrayList<>();
        for(int i=0;i<result.size();i++)
        {
            DonorInfo d = new DonorInfo();
            d.setBloodGroup(result.get(i)[0].toString());
            d.setHospitalName(result.get(i)[1].toString());
            d.setDonorName(result.get(i)[2].toString());
            d.setDonatedDateAndTime(result.get(i)[3].toString());

            di.add(d);
        }

        return di;
    }
}

/*

rename heart repo to organ repo
separate class for part of code in heartService.

future work:
donated time: 2021-04-13 01:26:32.132
expiary time 2 days.
48 hrs left...


 */