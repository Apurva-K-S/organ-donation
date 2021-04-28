package com.example.iiitb.OrganDonation;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.iiitb.OrganDonation.Beans.DonorInfo;
import com.example.iiitb.OrganDonation.Beans.LoginDetails;
import com.example.iiitb.OrganDonation.Beans.primaryUser;
import com.example.iiitb.OrganDonation.Beans.userOrganTable;
import com.example.iiitb.OrganDonation.DAO.LoginRepository;
import com.example.iiitb.OrganDonation.DAO.SecUserDetailsRepository;
import com.example.iiitb.OrganDonation.Services.HospitalRegisterService;
import com.example.iiitb.OrganDonation.Services.LoginService;
import com.example.iiitb.OrganDonation.Services.OrganServiceTwo;
import com.example.iiitb.OrganDonation.Services.SecUserDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class OrganDonationApplicationTests {

	@Test
	void contextLoads() {
	}

	LoginService loginService;
	HospitalRegisterService hospitalRegisterService;
	SecUserDetailsService secUserDetailsService;
	LoginRepository loginRepository;
	SecUserDetailsRepository secUserDetailsRepository;
	OrganServiceTwo organServiceTwo;

	@Autowired
	public OrganDonationApplicationTests(OrganServiceTwo organServiceTwo, SecUserDetailsRepository secUserDetailsRepository, LoginRepository loginRepository, LoginService loginService, HospitalRegisterService hospitalRegisterService, SecUserDetailsService secUserDetailsService){

		this.loginService = loginService;
		this.hospitalRegisterService = hospitalRegisterService;
		this.secUserDetailsService = secUserDetailsService;
		this.loginRepository = loginRepository;
		this.secUserDetailsRepository = secUserDetailsRepository;
		this.organServiceTwo = organServiceTwo;
	}

	@Test
	public void positiveTestPrimaryUserAuthentication()
	{
		LoginDetails loginDetails = new LoginDetails("user1@gmail.com","12345", "Primary User");
		int temp = loginService.authenticateUser(loginDetails.getLoginEmail(), loginDetails.getLoginPassword(), 1);
		assertEquals(temp, 1);
	}

	@Test
	public void negativeTestPrimaryUserAuthentication()
	{
		LoginDetails loginDetails = new LoginDetails("user1@gmail.com","12345", "Secondary User");
		int temp = loginService.authenticateUser(loginDetails.getLoginEmail(), loginDetails.getLoginPassword(), 2);
		assertNotEquals(temp, 1);
	}

	@Test
	public void positiveTestSecondaryUserAuthentication()
	{
		LoginDetails loginDetails = new LoginDetails("user1sec@gmail.com","12345", "Secondary User");
		int temp = loginService.authenticateUser(loginDetails.getLoginEmail(), loginDetails.getLoginPassword(), 2);
		assertEquals(temp, 1);
	}

	@Test
	public void negativeTestSecondaryUserAuthentication()
	{
		LoginDetails loginDetails = new LoginDetails("user1sec@gmail.com","12345", "Primary User");
		int temp = loginService.authenticateUser(loginDetails.getLoginEmail(), loginDetails.getLoginPassword(), 1);
		assertNotEquals(temp, 1);
	}


	@Test
	public void positiveTestAuthenticateHospital()
	{
		String result = hospitalRegisterService.authenticateHospital("hospital1@gmail.com", "12345");
		assertThat(result.equals("Hospital1"));
	}

	@Test
	public void negativeTestAuthenticateHospital()
	{
		String result = hospitalRegisterService.authenticateHospital("hospital1@gmail.com", "1234");
		assertNull(result);
	}

	@Test
	public void positiveTestGetOrgansList()
	{
		List<userOrganTable> temp = secUserDetailsService.getOrgansList("user1sec@gmail.com");
		List<userOrganTable> temp2 = new ArrayList<>();
		primaryUser pu = new primaryUser();
		/*primaryUser pu = new primaryUser(2,"user1", "u1", "user1@gmail.com","user1sec@gmail.com",
				"9999999999", "9898989898",
				"8888-8888-8888", "8777-7777-777", "true","Friend",
				"23", "O+", "Female", "12345", "user1sec", "u1s" );
				List<primaryUser> Lpu = loginRepository.findBySecondary_email("user1sec@gmail.com");

		List<userOrganTable> Luot = secUserDetailsRepository.findByPuserEmail(Lpu.get(0).getEmail());
		primaryUser tpu = temp.get(0).getPuser();

mysql> select * from primary_user where secondary_email = "user1sec@gmail.com";
+----+----------------+-----+-------------+-----------------+------------+--------+-----------+----------+------------+------------------+--------------------+----------------------+---------------------+-----------------+------------------------+---------------------------+
| id | aadhar         | age | blood_group | email           | first_name | gender | last_name | password | phone      | secondary_aadhar | secondary_email    | secondary_first_name | secondary_last_name | secondary_phone | secondary_relationship | terms_conditions_checkbox |
+----+----------------+-----+-------------+-----------------+------------+--------+-----------+----------+------------+------------------+--------------------+----------------------+---------------------+-----------------+------------------------+---------------------------+
|  2 | 8888-8888-8888 | 23  | O+          | user1@gmail.com | user1      | Female | u1        | 12345    | 9999999999 | 8777-7777-777    | user1sec@gmail.com | user1sec             | u1s                 | 9898989898      | Friend                 | true                      |
+----+----------------+-----+-------------+-----------------+------------+--------+-----------+----------+------------+------------------+--------------------+----------------------+---------------------+-----------------+------------------------+---------------------------+
		 */

		userOrganTable uot1 = new userOrganTable(4, pu, "Liver");
		temp2.add(uot1);

		userOrganTable uot2 = new userOrganTable(5, pu, "Kidney");
		temp2.add(uot2);

		userOrganTable uot3= new userOrganTable(6, pu, "Heart");
		temp2.add(uot3);


		List<String> listOfIds_temp = new ArrayList<>();
		List<String> listOfIds_temp2 = new ArrayList<>();
		List<String> listOfOrgans_temp = new ArrayList<>();
		List<String> listOfOrgans_temp2 = new ArrayList<>();


		for(int i=0;i<3;i++)
		{
			listOfIds_temp.add(temp.get(i).getId().toString());
			listOfIds_temp2.add(temp2.get(i).getId().toString());
			listOfOrgans_temp.add(temp.get(i).getOrgan());
			listOfOrgans_temp2.add(temp2.get(i).getOrgan());
		}

		assertEquals(listOfIds_temp, listOfIds_temp2);
		assertEquals(listOfOrgans_temp, listOfOrgans_temp2);

	}

	@Test
	public void negativeTestGetOrgansList()
	{
		List<userOrganTable> temp = secUserDetailsService.getOrgansList("user1sec@gmail.com");
		List<userOrganTable> temp2 = new ArrayList<>();
		primaryUser pu = new primaryUser();
		/*primaryUser pu = new primaryUser(2,"user1", "u1", "user1@gmail.com","user1sec@gmail.com",
				"9999999999", "9898989898",
				"8888-8888-8888", "8777-7777-777", "true","Friend",
				"23", "O+", "Female", "12345", "user1sec", "u1s" );
				List<primaryUser> Lpu = loginRepository.findBySecondary_email("user1sec@gmail.com");

		List<userOrganTable> Luot = secUserDetailsRepository.findByPuserEmail(Lpu.get(0).getEmail());
		primaryUser tpu = temp.get(0).getPuser();

mysql> select * from primary_user where secondary_email = "user1sec@gmail.com";
+----+----------------+-----+-------------+-----------------+------------+--------+-----------+----------+------------+------------------+--------------------+----------------------+---------------------+-----------------+------------------------+---------------------------+
| id | aadhar         | age | blood_group | email           | first_name | gender | last_name | password | phone      | secondary_aadhar | secondary_email    | secondary_first_name | secondary_last_name | secondary_phone | secondary_relationship | terms_conditions_checkbox |
+----+----------------+-----+-------------+-----------------+------------+--------+-----------+----------+------------+------------------+--------------------+----------------------+---------------------+-----------------+------------------------+---------------------------+
|  2 | 8888-8888-8888 | 23  | O+          | user1@gmail.com | user1      | Female | u1        | 12345    | 9999999999 | 8777-7777-777    | user1sec@gmail.com | user1sec             | u1s                 | 9898989898      | Friend                 | true                      |
+----+----------------+-----+-------------+-----------------+------------+--------+-----------+----------+------------+------------------+--------------------+----------------------+---------------------+-----------------+------------------------+---------------------------+
		 */

		userOrganTable uot1 = new userOrganTable(4, pu, "Liver");
		temp2.add(uot1);

		userOrganTable uot2 = new userOrganTable(4, pu, "Liver");
		temp2.add(uot2);

		userOrganTable uot3= new userOrganTable(4, pu, "Liver");
		temp2.add(uot3);


		List<String> listOfIds_temp = new ArrayList<>();
		List<String> listOfIds_temp2 = new ArrayList<>();
		List<String> listOfOrgans_temp = new ArrayList<>();
		List<String> listOfOrgans_temp2 = new ArrayList<>();


		for(int i=0;i<3;i++)
		{
			listOfIds_temp.add(temp.get(i).getId().toString());
			listOfIds_temp2.add(temp2.get(i).getId().toString());
			listOfOrgans_temp.add(temp.get(i).getOrgan());
			listOfOrgans_temp2.add(temp2.get(i).getOrgan());
		}

		assertNotEquals(listOfIds_temp, listOfIds_temp2);
		assertNotEquals(listOfOrgans_temp, listOfOrgans_temp2);

	}

	@Test
	public void positiveTestGetDonorInfo()
	{
		// | A+          | Hospital3     | user4      | 2021-04-19 18:12:42.989000 |
		List<DonorInfo> temp = organServiceTwo.getDonorInfo("Eyes", "A+", "Hospital3");
		List<DonorInfo> temp2 = new ArrayList<>();
		primaryUser pu = new primaryUser();

		DonorInfo di1 = new DonorInfo("A+", "Hospital3", "user4", "2021-04-19 18:12:42.989");
		temp2.add(di1);


		List<String> lobg_temp = new ArrayList<>();
		List<String> lobg_temp2 = new ArrayList<>();
		List<String> lohns_temp = new ArrayList<>();
		List<String> lohns_temp2 = new ArrayList<>();
		List<String> lodns_temp = new ArrayList<>();
		List<String> lodns_temp2 = new ArrayList<>();
		List<String> loddt_temp = new ArrayList<>();
		List<String> loddt_temp2 = new ArrayList<>();


		for(int i=0;i<1;i++)
		{
			lobg_temp.add(temp.get(i).getBloodGroup()); lobg_temp2.add(temp2.get(i).getBloodGroup());
			lohns_temp.add(temp.get(i).getHospitalName()); lohns_temp2.add(temp2.get(i).getHospitalName());
			lodns_temp.add(temp.get(i).getDonorName()); lodns_temp2.add(temp2.get(i).getDonorName());
			loddt_temp.add(temp.get(i).getDonatedDateAndTime()); loddt_temp2.add(temp2.get(i).getDonatedDateAndTime());
		}

		assertEquals(lobg_temp, lobg_temp2);
		assertEquals(lohns_temp, lohns_temp2);
		assertEquals(lodns_temp, lodns_temp2);
		assertEquals(loddt_temp, loddt_temp2);

	}

	@Test
	public void negativeTestGetDonorInfo()
	{
		List<DonorInfo> temp = organServiceTwo.getDonorInfo("Eyes", "O+", "Hospital4");
		List<DonorInfo> temp2 = new ArrayList<>();
		primaryUser pu = new primaryUser();

		DonorInfo di1 = new DonorInfo("A+", "Hospital3", "user4", "2021-04-19 18:12:42.989");
		temp2.add(di1);


		List<String> lobg_temp = new ArrayList<>();
		List<String> lobg_temp2 = new ArrayList<>();
		List<String> lohns_temp = new ArrayList<>();
		List<String> lohns_temp2 = new ArrayList<>();
		List<String> lodns_temp = new ArrayList<>();
		List<String> lodns_temp2 = new ArrayList<>();
		List<String> loddt_temp = new ArrayList<>();
		List<String> loddt_temp2 = new ArrayList<>();


		for(int i=0;i<1;i++)
		{
			lobg_temp.add(temp.get(i).getBloodGroup()); lobg_temp2.add(temp2.get(i).getBloodGroup());
			lohns_temp.add(temp.get(i).getHospitalName()); lohns_temp2.add(temp2.get(i).getHospitalName());
			lodns_temp.add(temp.get(i).getDonorName()); lodns_temp2.add(temp2.get(i).getDonorName());
			loddt_temp.add(temp.get(i).getDonatedDateAndTime()); loddt_temp2.add(temp2.get(i).getDonatedDateAndTime());
		}

		assertNotEquals(lobg_temp, lobg_temp2);
		assertNotEquals(lohns_temp, lohns_temp2);
		assertNotEquals(lodns_temp, lodns_temp2);
		assertNotEquals(loddt_temp, loddt_temp2);
	}
}
