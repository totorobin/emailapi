package com.capgemini.emailapi.controller;


import com.capgemini.emailapi.model.Mail;
import com.capgemini.emailapi.services.MailService;
import com.capgemini.emailapi.services.SMTPMailService;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    MailService mailService;

    @PostMapping("/send")
    public String send(@RequestBody Mail mail) {

        try {
            mailService.sendEmail(mail.getContent(), mail.getObject(), mail.getSender(), mail.getReceivers());
            return "Message Sent";
        } catch (MailException e) {
            return e.getLocalizedMessage();
        } catch (MailjetSocketTimeoutException e) {
            return e.getLocalizedMessage();
        } catch (MailjetException e) {
            return e.getLocalizedMessage();
        }
    }
}
