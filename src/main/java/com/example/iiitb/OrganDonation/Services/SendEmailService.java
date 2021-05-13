package com.example.iiitb.OrganDonation.Services;

import com.example.iiitb.OrganDonation.Controller.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;

@Named
@Slf4j
public class SendEmailService {

    private JavaMailSender javaMailSender;
    private static final Logger logger = LoggerFactory.getLogger(SendEmailService.class);
    //private static final Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    public SendEmailService(JavaMailSender javaMailSender)
    {
        logger.info("[INFO]: inside SendEmailService()");
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String to, String subject, String message)
    {
        logger.info("[INFO]: inside SendEmailService:sendEmail()");
        System.out.println("Inside SendEmailService:sendEmail");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        //Uncomment to send mail
        javaMailSender.send(simpleMailMessage);
    }

}
