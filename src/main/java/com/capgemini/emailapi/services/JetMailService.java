package com.capgemini.emailapi.services;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.MailException;
import com.mailjet.client.MailjetClient;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

@Service
@Profile("demo")
public class JetMailService implements MailService {


    MailjetClient client;

    @Autowired
    public JetMailService(@Value("${spring.jetmail.apikey}") String key, @Value("${spring.jetmail.apisecret}") String secret) {
        this.client = new MailjetClient(key,secret, new ClientOptions("v3.1"));
    }

    @Override
    public void sendEmail(String content, String object, String sender, List<String> receivers) throws MailException, MailjetSocketTimeoutException, MailjetException {
        JSONArray listreceivers = new JSONArray();
        receivers.forEach(r -> listreceivers.put(new JSONObject().put("Email", r)));

        MailjetRequest request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email","cnr@yopmail.com")
                                        .put("Name", "Mail Automatique MailJet"))
                                .put(Emailv31.Message.REPLYTO,new JSONObject()
                                        .put("Email",sender) )
                                .put(Emailv31.Message.TO, listreceivers)
                                .put(Emailv31.Message.SUBJECT, object)
                                .put(Emailv31.Message.TEXTPART, content)));

        MailjetResponse response = client.post(request);
    }
}
