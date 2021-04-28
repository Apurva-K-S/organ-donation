package com.example.iiitb.OrganDonation.Services;

import com.example.iiitb.OrganDonation.Beans.*;
import com.example.iiitb.OrganDonation.DAO.LoginRepository;
import com.example.iiitb.OrganDonation.DAO.OrganRequestRepository;
import com.example.iiitb.OrganDonation.DAO.RequestResponseRepository;
import com.example.iiitb.OrganDonation.DAO.UserFinalOrganTableRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Named
public class OrganRequestResponseService {

    private OrganRequestRepository orgReqRepo;
    private RequestResponseRepository requestResponseRepository;
    private LoginRepository loginRepository;
    private SendEmailService sendEmailService;
    private UserFinalOrganTableRepository userFinalOrganTableRepository;

    @Autowired
    public OrganRequestResponseService(UserFinalOrganTableRepository userFinalOrganTableRepository, SendEmailService sendEmailService, OrganRequestRepository orgReqRepo, RequestResponseRepository requestResponseRepository, LoginRepository loginRepository)
    {
        this.orgReqRepo = orgReqRepo;
        this.requestResponseRepository = requestResponseRepository;
        this.loginRepository = loginRepository;
        this.sendEmailService = sendEmailService;
        this.userFinalOrganTableRepository = userFinalOrganTableRepository;
    }

    public boolean getOrganRequestDetails(OrganRequest organRequest)
    {
        System.out.println("Inside getOrganRequestDetails Service Class");

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

        iterator = organs.listIterator();


        List<RequestResponse> listOfRequestReponse = new ArrayList<>();
        while (iterator.hasNext())
        {
            RequestResponse requestResponse = new RequestResponse();
            RequestResponse result = new RequestResponse();
            //System.out.println("\n\nInside while loop");
            String organName= iterator.next();
            List<Object[]> t = orgReqRepo.findOrganByHospital(organName, organRequest.getBloodGroup());
            //System.out.println(t.get(0)[0]  + " " + t.get(0)[1]);
            //select pu.first_name, pu.secondary_email, oht.hospital_name, hr.hosp_email, ufot.organ, pu.blood_group, oht.datetime
            requestResponse.setDonorName(t.get(0)[0].toString());
            requestResponse.setDonorEmail(t.get(0)[1].toString());
            requestResponse.setRecepientName(organRequest.getPatientFirstName());
            requestResponse.setRecepientEmail(organRequest.getPatientEmail());
            requestResponse.setDonorHospital(t.get(0)[2].toString());
            requestResponse.setDonorHospitalEmail(t.get(0)[3].toString());
            requestResponse.setRequestHospitalEmail(organRequest.getHospitalEmail());
            requestResponse.setOrgan(organName);
            requestResponse.setBloodGroup(organRequest.getBloodGroup());
            requestResponse.setStatus(0); // 0->request not yet satisfied. 1->request satisfied.

            result = requestResponseRepository.save(requestResponse);

            listOfRequestReponse.add(requestResponse);

            if(result==null)
                return false;
        }

        System.out.println("-------------Displaying all the rows---------------------------");
        for(int i=0;i<listOfRequestReponse.size();i++)
        {
            System.out.print(listOfRequestReponse.get(i).getDonorName() + "  ");
            System.out.print(listOfRequestReponse.get(i).getDonorEmail() + "  ");
            System.out.print(listOfRequestReponse.get(i).getRecepientName() + "  ");
            System.out.print(listOfRequestReponse.get(i).getRecepientEmail() + "  ");
            System.out.print(listOfRequestReponse.get(i).getDonorHospital() + "  ");
            System.out.print(listOfRequestReponse.get(i).getDonorHospitalEmail() + "  ");
            System.out.print(listOfRequestReponse.get(i).getRequestHospitalEmail() + "  ");
            System.out.print(listOfRequestReponse.get(i).getOrgan() + "  ");
            System.out.print(listOfRequestReponse.get(i).getBloodGroup() + "  ");
            System.out.print(listOfRequestReponse.get(i).getStatus() + "  ");
            System.out.print("\n\n--------------------------------------------------------\n\n");

        }
        return true;
    }

    public List<OrganResponse> getResponseData(String hospitalName)
    {
        System.out.println("inside OrganRequestResponseService:getResponseData");
        List<List<Object[]>> data= requestResponseRepository.findByDonorHospital(hospitalName);
        List<OrganResponse> organResponses=new ArrayList<>();

        /*for(int i=0;i<data.size();i++)
        {
            System.out.println(data.get(i).get(1)[0]);
        }*/
        for(int i=0;i<data.size();i++)
        {
            OrganResponse organResponse = new OrganResponse();

            organResponse.setDonorName(data.get(i).get(0)[0].toString());
            organResponse.setDonorEmail(data.get(i).get(1)[0].toString());
            organResponse.setRecepientName(data.get(i).get(2)[0].toString());
            organResponse.setDonorHospital(data.get(i).get(3)[0].toString());
            organResponse.setRequestHospitalEmail(data.get(i).get(4)[0].toString());
            organResponse.setOrgan(data.get(i).get(5)[0].toString());
            organResponse.setBloodGroup(data.get(i).get(6)[0].toString());

            organResponses.add(organResponse);

        }
        //donor_name, donor_email, recepient_name, donor_hospital, request_hospital_email, organ, blood_group

        /*
        private String donorName;
    private String donorEmail;
    private String recepientName;
    private String donorHospital;
    private String requestHospitalEmail;
    private String organ;
    private String bloodGroup;
         */
        return organResponses;
    }

    public boolean deletingCorrespondingData(OrganResponse organResponse)
    {
        System.out.println("inside OrganRequestResponseService:deletingCorrespondingData");
        //----------------------------------------------------------------------------------------------------------------------
        // here we have to delete entry from user_final_organ_table
        // for this we need primary user's email. so first get it.

        System.out.println("deleting from user final organ table.");
        boolean temp = deletingRequestResponse(organResponse);
        System.out.println("came back from deleting request function");

        //-------------------------------------------------------------------------------------------------------------------------
        //change the value of status from 0 to 1 in request_response table.
        // UPDATE----------------------------------------------------------

        System.out.println("\n\nupdating the status of request response");
        boolean stat = updateRequestResponse(organResponse.getDonorName(), organResponse.getOrgan());

        System.out.println("status is: = " + stat);
        //----------------------------------------------------------------------------------------------------------------------------

        //---------------------------------------------------------------------------------------------------------------------------
        System.out.println("send emails to donor_hospital, requested_hospital and donorEmail.");
        sendEmails(organResponse);
        // if all worked send true if any one failed return false.

        // modify query such that it checks status.. query of RequestResponseRepository.


        return stat;
    }

    public boolean updateRequestResponse(String donorName, String Organ)
    {
        List<RequestResponse> LRR = requestResponseRepository.findByDonorNameAndOrgan(donorName, Organ);

        System.out.println("Size of List of RequestResponse = " + LRR.size());
        System.out.println("id is: = " + LRR.get(0).getId());

        RequestResponse row = LRR.get(0);
        row.setStatus(1);
        RequestResponse temp = requestResponseRepository.save(row);
        if(temp == null)
            return false;
        return true;
    }

    public boolean deletingRequestResponse(OrganResponse organResponse)
    {
        List<primaryUser> LPU = loginRepository.findBySecondary_email(organResponse.getDonorEmail());

        System.out.println("donorEmail = " + LPU.get(0).getEmail());

        List<Object[]> LUFOT = requestResponseRepository.findByDonorEmailAndOrgan(LPU.get(0).getEmail(), organResponse.getOrgan());

        System.out.println("size of list of user final organ table is = " + LUFOT.size());
        System.out.println("\n" + LUFOT.get(0)[0] + " --- " + LUFOT.get(0)[1].toString() + " ---- " + LUFOT.get(0)[2].toString());
        userFinalOrganTableRepository.deleteById((Integer)(LUFOT.get(0)[0]));

        System.out.println("\nDeleted... check in db now!!");
        return true;
    }

    public boolean sendEmails(OrganResponse organResponse)
    {
        String donor_hospital_message = "Patient named " + organResponse.getDonorName() + " donated their " + organResponse.getOrgan() + " to your hospital. You have approved its transmission to "
                + organResponse.getRequestHospitalEmail() + " . ";

        String requested_hospital_message = " Your request for organ = " + organResponse.getOrgan() + " for patient = " + organResponse.getRecepientName() + " has been approved by hospital = " + organResponse.getDonorHospital();

        String donor_email_message = "Your organs have been donated to patient = " + organResponse.getRecepientName() + " by the hospital = " + organResponse.getDonorHospital();

        List<Object[]> hnames = requestResponseRepository.findByDonorHospitalName(organResponse.getDonorHospital());
        //System.out.println("hospital name = " + organResponse.getDonorHospital() + " its email is = " + hnames.get(0)[0].toString())

        sendEmailService.sendEmail(hnames.get(0)[0].toString(), "from OrganDonantion", donor_hospital_message);
        sendEmailService.sendEmail(organResponse.getRequestHospitalEmail(), "from OrganDonantion", requested_hospital_message);
        sendEmailService.sendEmail(organResponse.getDonorEmail(), "from OrganDonantion", donor_email_message);

        return true;
    }
}
