package com.capgemini.emailapi.model;

import java.util.List;
import java.util.Map;

public class Mail {

    private String sender;
    private List<String> receivers;
    private String object;
    private String content;
    private String templateName;
    private Map<String, Object> templateData;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public List<String> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<String> receivers) {
        this.receivers = receivers;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Map<String, Object>  getTemplateData() {
        return templateData;
    }

    public void setTemplateData(Map<String, Object>  templateData) {
        this.templateData = templateData;
    }

    @Override
    public String toString() {
        return "{" +
                "\n sender='" + sender + '\'' +
                "\n receivers=" + receivers +
                "\n object='" + object + '\'' +
                "\n content='" + content + '\'' +
                "\n templateName='" + templateName + '\'' +
                "\n templateData=" + templateData +
                "\n}";
    }
}
