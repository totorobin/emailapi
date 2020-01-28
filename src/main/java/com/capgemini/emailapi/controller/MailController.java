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
    public String send(@RequestBody Mail mail) {
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
            return "Message Sent";
        }  catch (MalformedTemplateNameException e) {
            return e.getLocalizedMessage();
        } catch (ParseException e) {
            return e.getLocalizedMessage();
        } catch (MailException e) {
            return e.getLocalizedMessage();
        } catch (MailjetSocketTimeoutException e) {
            return e.getLocalizedMessage();
        } catch (MailjetException e) {
            return e.getLocalizedMessage();
        } catch (TemplateNotFoundException e) {
            return e.getLocalizedMessage();
        } catch (IOException e) {
            return e.getLocalizedMessage();
        } catch (MessagingException e) {
            return e.getLocalizedMessage();
        } catch (TemplateException e) {
            return e.getLocalizedMessage();
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
