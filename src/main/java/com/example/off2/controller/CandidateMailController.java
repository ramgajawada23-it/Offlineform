package com.example.off2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CandidateMailController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/send-form")
    public String sendForm(@RequestBody Map<String, String> data) {
        try {
            String candidateEmail = data.get("candidateEmail");
            String agreementName = data.getOrDefault("agreementName", "Candidate Onboarding Form");
            String customMessage = data.getOrDefault("message",
                    "Please click the link below to fill out your onboarding form.");
            String formLink = data.getOrDefault("formLink", "http://localhost:8080/index.html");
            String ccEmails = data.get("ccEmails");

            if (candidateEmail == null || candidateEmail.isEmpty()) {
                return "Error: Candidate Email is required!";
            }

            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(candidateEmail);
            mail.setSubject(agreementName);
            mail.setText("Hello,\n\n" + customMessage + "\n\nForm Link: " + formLink + "\n\nBest regards,\nHR Team");

            // Handle CC if provided
            if (ccEmails != null && !ccEmails.trim().isEmpty()) {
                String[] ccArray = ccEmails.split(",");
                for (int i = 0; i < ccArray.length; i++) {
                    ccArray[i] = ccArray[i].trim();
                }
                mail.setCc(ccArray);
            }

            mailSender.send(mail);

            return "Mail sent successfully to " + candidateEmail;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending mail: " + e.getMessage();
        }
    }
}
