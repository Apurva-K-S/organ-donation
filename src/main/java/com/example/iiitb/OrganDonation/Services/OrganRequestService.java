package com.example.iiitb.OrganDonation.Services;

import com.example.iiitb.OrganDonation.Beans.OrganRequest;
import com.example.iiitb.OrganDonation.Beans.OrganResponse;
import com.example.iiitb.OrganDonation.DAO.OrganRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Named
public class OrganRequestService {

    private OrganRequestRepository orgReqRepo;

    @Autowired
    public OrganRequestService(OrganRequestRepository orgReqRepo)
    {
        this.orgReqRepo = orgReqRepo;
    }

    public List<OrganResponse> getOrganRequestDetails(OrganRequest organRequest)
    {
        System.out.println("Inside getOrganRequestDetails Service Class");
        List<OrganResponse> orgResp = new ArrayList<>();
        List<String> organs = new ArrayList<>();

        if(organRequest.getOrgan_Heart().equals("true"))
            organs.add("Heart");
        if(organRequest.getOrgan_Eyes().equals("true"))
            organs.add("Eyes");
        if(organRequest.getOrgan_Kidney().equals("true"))
            organs.add("Kidney");
        if(organRequest.getOrgan_Liver().equals("true"))
            organs.add("Liver");

        ListIterator<String> iterator = organs.listIterator();
        System.out.println("total number of organs (inside OrgReqService): " + organs.size());
        System.out.println("organs are (inside OrgReqService): ");
        while (iterator.hasNext()) {
            System.out.println("Organ is : " + iterator.next());
        }



        while (iterator.hasNext())
        {
            OrganResponse result = new OrganResponse();
            result = orgReqRepo.findOrganByHospital(iterator.next(),organRequest.getBloodGroup());
            orgResp.add(result);

        }

        ListIterator<OrganResponse> itr = orgResp.listIterator();
        OrganResponse temp;
        while(itr.hasNext())
        {
            temp=itr.next();
            System.out.println("=============Organ Response List============");
            System.out.println(temp.getPatientFirstName());
            System.out.println(temp.getHospitalEmail());
            System.out.println(temp.getOrgan());
            System.out.println(temp.getBloodGroup());
        }


        return orgResp;
    }
}
