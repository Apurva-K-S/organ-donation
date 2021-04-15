package com.example.iiitb.OrganDonation.Controller;


import com.example.iiitb.OrganDonation.Beans.Organ;
import com.example.iiitb.OrganDonation.Services.OrganServiceTwo;
import com.example.iiitb.OrganDonation.Services.KidneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path="/api")
public class OrganController {

    private KidneyService KidneyService;
    private OrganServiceTwo organServiceTwo;

    @Autowired
    public OrganController(OrganServiceTwo organServiceTwo, KidneyService KidneyService)
    {
        this.organServiceTwo = organServiceTwo;
        this.KidneyService = KidneyService;
    }

    @GetMapping(path="/getHeartOrgan", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    //@GetMapping("/secUserGetList")
    public @ResponseBody
    List<Organ> sendHeartDetails() {

        System.out.println("inside: OrganController:sendHeartDetails\n");
        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        List<Organ> hearts = organServiceTwo.getOrgnData("Heart");

        System.out.println("\ncoming out of : HeartController:sendHeartDetails\n");

        //return temph;
        return hearts;
    }

    @GetMapping(path="/getKidneyOrgan", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    //@GetMapping("/secUserGetList")
    public @ResponseBody
    List<Organ> sendKidneyDetails() {

        System.out.println("inside: OrganController:sendKidneytDetails\n");
        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        List<Organ> kidneys = organServiceTwo.getOrgnData("Kidney");

        System.out.println("\ncoming out of : OrganController:sendKidneyDetails\n");

        //return temph;
        return kidneys;
    }

    @GetMapping(path="/getLiverOrgan", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    //@GetMapping("/secUserGetList")
    public @ResponseBody
    List<Organ> sendLiverDetails() {

        System.out.println("inside: OrganController:sendLiverDetails\n");
        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        List<Organ> livers = organServiceTwo.getOrgnData("Liver");

        System.out.println("\ncoming out of : OrganController:sendLiverDetails\n");

        //return temph;
        return livers;
    }

    @GetMapping(path="/getEyesOrgan", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    //@GetMapping("/secUserGetList")
    public @ResponseBody
    List<Organ> sendEyesDetails() {

        System.out.println("inside: OrganController:sendEyesDetails\n");
        System.out.println("Call sequence is: frontend(card icon: view details) -> frontend(component) -> frontend(service) " +
                "-> backend(Controller) -> backend(service) -> backend(Repository)");

        List<Organ> eyes = organServiceTwo.getOrgnData("Eyes");

        System.out.println("\ncoming out of : OrganController:sendEyesDetails\n");

        //return temph;
        return eyes;
    }
}

/*

mysql> show tables;
+-------------------------+
| Tables_in_OrganDonation |
+-------------------------+
| organ_user_table        |
| primary_user            |
| user_hospital_table     |
+-------------------------+
3 rows in set (0.00 sec)

mysql> describe organ_user_table;
+------------+--------------+------+-----+---------+----------------+
| Field      | Type         | Null | Key | Default | Extra          |
+------------+--------------+------+-----+---------+----------------+
| id         | int          | NO   | PRI | NULL    | auto_increment |
| organ      | varchar(255) | YES  |     | NULL    |                |
| user_email | varchar(255) | YES  | MUL | NULL    |                |
+------------+--------------+------+-----+---------+----------------+
3 rows in set (0.03 sec)

mysql> describe user_hospital_table;
+---------------+--------------+------+-----+---------+----------------+
| Field         | Type         | Null | Key | Default | Extra          |
+---------------+--------------+------+-----+---------+----------------+
| id            | int          | NO   | PRI | NULL    | auto_increment |
| datetime      | datetime(6)  | YES  |     | NULL    |                |
| hospital_name | varchar(255) | YES  | UNI | NULL    |                |
| user_email    | varchar(255) | YES  | MUL | NULL    |                |
+---------------+--------------+------+-----+---------+----------------+
4 rows in set (0.00 sec)

mysql> select * from organ_user_table ou, user_hospital_table uht where ou.user_email = uht.user_email;
+----+--------+---------------------------+----+----------------------------+---------------+---------------------------+
| id | organ  | user_email                | id | datetime                   | hospital_name | user_email                |
+----+--------+---------------------------+----+----------------------------+---------------+---------------------------+
|  1 | Liver  | sambhavi.apurva@iiitb.org |  1 | 2021-04-13 01:26:32.132000 | Hospital3     | sambhavi.apurva@iiitb.org |
|  2 | Kidney | sambhavi.apurva@iiitb.org |  1 | 2021-04-13 01:26:32.132000 | Hospital3     | sambhavi.apurva@iiitb.org |
|  3 | Heart  | sambhavi.apurva@iiitb.org |  1 | 2021-04-13 01:26:32.132000 | Hospital3     | sambhavi.apurva@iiitb.org |
|  4 | Liver  | user1@gmail.com           |  2 | 2021-04-13 07:00:00.000000 | hospital2     | user1@gmail.com           |
|  5 | Kidney | user1@gmail.com           |  2 | 2021-04-13 07:00:00.000000 | hospital2     | user1@gmail.com           |
|  6 | Heart  | user1@gmail.com           |  2 | 2021-04-13 07:00:00.000000 | hospital2     | user1@gmail.com           |
|  7 | Liver  | user2@gmail.com           |  3 | 2021-04-13 08:00:00.000000 | hospital1     | user2@gmail.com           |
|  8 | Kidney | user2@gmail.com           |  3 | 2021-04-13 08:00:00.000000 | hospital1     | user2@gmail.com           |
|  9 | Heart  | user2@gmail.com           |  3 | 2021-04-13 08:00:00.000000 | hospital1     | user2@gmail.com           |
| 10 | Liver  | user4@gmail.com           |  4 | 2021-04-13 07:00:00.000000 | hospital4     | user4@gmail.com           |
| 11 | Kidney | user4@gmail.com           |  4 | 2021-04-13 07:00:00.000000 | hospital4     | user4@gmail.com           |
| 12 | Heart  | user4@gmail.com           |  4 | 2021-04-13 07:00:00.000000 | hospital4     | user4@gmail.com           |
| 13 | Liver  | user5@gmail.com           |  5 | 2021-04-13 08:00:00.000000 | hospital5     | user5@gmail.com           |
| 14 | Kidney | user5@gmail.com           |  5 | 2021-04-13 08:00:00.000000 | hospital5     | user5@gmail.com           |
| 15 | Heart  | user5@gmail.com           |  5 | 2021-04-13 08:00:00.000000 | hospital5     | user5@gmail.com           |
| 16 | Liver  | user6@gmail.com           |  6 | 2021-04-13 09:00:00.000000 | hospital6     | user6@gmail.com           |
| 17 | Kidney | user6@gmail.com           |  6 | 2021-04-13 09:00:00.000000 | hospital6     | user6@gmail.com           |
| 18 | Heart  | user6@gmail.com           |  6 | 2021-04-13 09:00:00.000000 | hospital6     | user6@gmail.com           |
+----+--------+---------------------------+----+----------------------------+---------------+---------------------------+
18 rows in set (0.00 sec)

mysql> select uht.hospital_name, count(organ) from organ_user_table ou, user_hospital_table uht where ou.user_email = uht.user_email group by uht.hospital_name;
+---------------+--------------+
| hospital_name | count(organ) |
+---------------+--------------+
| Hospital3     |            3 |
| hospital2     |            3 |
| hospital1     |            3 |
| hospital4     |            3 |
| hospital5     |            3 |
| hospital6     |            3 |
+---------------+--------------+
6 rows in set (0.02 sec)

mysql> select uht.hospital_name, organ, count(organ) from organ_user_table ou, user_hospital_table uht where ou.user_email = uht.user_email group by uht.hospital_name
, ou.organ;
+---------------+--------+--------------+
| hospital_name | organ  | count(organ) |
+---------------+--------+--------------+
| Hospital3     | Liver  |            1 |
| Hospital3     | Kidney |            1 |
| Hospital3     | Heart  |            1 |
| hospital2     | Liver  |            1 |
| hospital2     | Kidney |            1 |
| hospital2     | Heart  |            1 |
| hospital1     | Liver  |            1 |
| hospital1     | Kidney |            1 |
| hospital1     | Heart  |            1 |
| hospital4     | Liver  |            1 |
| hospital4     | Kidney |            1 |
| hospital4     | Heart  |            1 |
| hospital5     | Liver  |            1 |
| hospital5     | Kidney |            1 |
| hospital5     | Heart  |            1 |
| hospital6     | Liver  |            1 |
| hospital6     | Kidney |            1 |
| hospital6     | Heart  |            1 |
+---------------+--------+--------------+
18 rows in set (0.00 sec)

mysql>



 */