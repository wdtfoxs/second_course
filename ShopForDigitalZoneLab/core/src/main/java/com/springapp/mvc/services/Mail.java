package com.springapp.mvc.services;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class Mail {

    private String username = "SendingMailYande@yandex.ru";
    private String password = "yandexSendingMail";

    public void sendMessage(String subject, String text, String to) throws MessagingException {
        MimeMessage message = new MimeMessage(getSession());
        message.setFrom(new InternetAddress("SendingMailYande@yandex.ru"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(text, "utf-8", "html");
        Transport.send(message);
    }

    public Session getSession() {
        return Session.getInstance(getProps(),
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
    }

    public Properties getProps() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.yandex.ru");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        return props;
    }


    public void sendActivation(String name, String key, String email) throws MessagingException {
        sendMessage("Здравствуйте, " + name + "!",
                "Перейдите по <a href=http://localhost:8080/signup?key=" + key + "&email=" + email + "> ссылке</a> для активации аккаунта: ",
                email);
    }
}