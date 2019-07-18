package com.capgemini.emailapi.services;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import org.springframework.mail.MailException;

import java.util.List;

public interface MailService {

    void sendEmail(String content, String object, String sender, List<String> receivers) throws MailException, MailjetSocketTimeoutException, MailjetException;
}
