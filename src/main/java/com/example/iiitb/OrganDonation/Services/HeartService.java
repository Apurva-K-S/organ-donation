package com.example.iiitb.OrganDonation.Services;

import com.example.iiitb.OrganDonation.Beans.HeartAllData;
import com.example.iiitb.OrganDonation.DAO.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class HeartService {

    HeartRepository heartRepository;

    @Autowired
    public HeartService(HeartRepository heartRepository)
    {
        this.heartRepository = heartRepository;
    }

    public void getHeartData()
    {
        System.out.println("inside: HeartService: getHeartData()");
        List<Object[]> t = new ArrayList<Object[]>();
        t = heartRepository.findByOrgan("Heart");

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
        List<Object[]> temp = heartRepository.findByOrganContaining("Heart");
        for(int i=0;i<temp.size();i++)
        {
            for(int j=0;j<temp.get(i).length;j++)
            {
                System.out.print(temp.get(i)[j] + "  ");
            }
            System.out.println("");
        }
        System.out.println("----------------------------------------------------------------------------------------------");

        System.out.println("coming out of getHeartData");

        /*
            needed:
            private String bloodGroup;
            private Integer count;
            private Date timer;
            private String donorName;
            private String hospitalName;

            bloodGroup -> primary_user
            count -> aggregate operation
            timer -> user_hospital_table
            donorName -> organ_user_table
            hospitalName -> user_hospital_table

            primary_user - organ_user_table         :   email [ email: primary_user && email: organ_user_table ]
            primary_user - user_hospital_table      :   email [ user_email: user_hospital_table && email: primary_user]

        */

        /*

        select pu.blood_group, count(*), oht.hospital_name, oht.datetime, out.organ, pu.first_name
        from primary_user pu, organ_user_table out, user_hospital_table uht
        where pu.email = out.user_email and oht.user_email = pu.email and out.organ = "Heart";
        group by pu.blood_group, oht.hospital_name, oht.datetime, out.organ, pu.first_name
         */

        //return t;
    }
}
