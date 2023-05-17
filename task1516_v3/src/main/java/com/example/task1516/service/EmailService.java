package com.example.task1516.service;

import com.example.task1516.entity.Departure;
import com.example.task1516.entity.PostOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

public class EmailService {
    @Autowired
    public JavaMailSender emailSender;

    @Async
    public void sendAddDepartureEmail(Departure departure){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("ilya01122003lid@yandex.ru");
        message.setTo("ilya01122003lid@yandex.ru");
        message.setSubject("Message from Spring Boot Application");
        message.setText(departure.toString());

        this.emailSender.send(message);
        System.out.println("Email successfully sent!");
    }

    @Async
    public void sendAddPostOfficeEmail(PostOffice postOffice){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("ilya01122003lid@yandex.ru");
        message.setTo("ilya01122003lid@yandex.ru");
        message.setSubject("Message from Spring Boot Application");
        message.setText(postOffice.toString());

        this.emailSender.send(message);
        System.out.println("Email successfully sent!");
    }
}
