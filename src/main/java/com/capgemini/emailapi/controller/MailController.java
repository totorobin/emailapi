package com.capgemini.emailapi.controller;


import com.capgemini.emailapi.model.Mail;
import com.capgemini.emailapi.services.MailService;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import freemarker.core.ParseException;
import freemarker.template.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashMap;

@RestController
public class MailController {

    MailService mailService;

    private Configuration freemarkerConfig;

    private String logoUrl;

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public MailController(MailService mailService, Configuration freemarkerConfig, @Value("${spring.url.logo}") String logoUrl) {
        this.mailService = mailService;
        this.logoUrl = logoUrl;
        this.freemarkerConfig = freemarkerConfig;
    }



    @PostMapping("/send")
    @CrossOrigin
    public ResponseEntity send(@RequestBody Mail mail) {
        LOG.info("Envoi de mail :\n" + mail.toString());
        try {
            if(mail.getTemplateName() != null && mail.getTemplateData() != null) {
                mail.getTemplateData().put("logo_url", logoUrl);
                Template t = freemarkerConfig.getTemplate(mail.getTemplateName() +".ftl");
                String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getTemplateData());
                mailService.sendTemplatedEmail(html, mail.getObject(), mail.getSender(), mail.getReceivers());
            } else {
                mailService.sendEmail(mail.getContent(), mail.getObject(), mail.getSender(), mail.getReceivers());
            }
            return new ResponseEntity("Message Sent",HttpStatus.OK );
        }  catch (MalformedTemplateNameException e) {
            return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        } catch (ParseException e) {
            return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        } catch (MailException e) {
            return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (MailjetSocketTimeoutException e) {
            return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (MailjetException e) {
            return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (TemplateNotFoundException e) {
            return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        } catch (MessagingException e) {
            return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (TemplateException e) {
            return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/testTemplate")
    public String testTemplate(@RequestBody HashMap<String, Object> data, @RequestParam(value = "name", defaultValue = "cnr-1") String name) throws IOException, TemplateException {

        data.put("logo_url", logoUrl);
        Template t = freemarkerConfig.getTemplate(name+".ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, data);

        return html;
    }
}
