package com.example.off2.controller;

import com.example.off2.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CandidateMailController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private CandidateRepository candidateRepository;

    @Value("${app.base-url}")
    private String baseUrl;

    @PostMapping("/send-form")
    public String sendForm(@RequestBody Map<String, String> data) {
        try {
            String candidateEmail = data.get("candidateEmail");
            String candidateMobile = data.get("candidateMobile");
            String hrEmail = data.get("hrEmail");
            String agreementName = data.getOrDefault("agreementName", "Candidate Onboarding Form");
            String customMessage = data.getOrDefault("message",
                    "Please click the link below to fill out your onboarding form.");
            String formLink = data.getOrDefault("formLink", baseUrl + "/login.html");
            String ccEmails = data.get("ccEmails");

            if (candidateEmail == null || candidateEmail.isEmpty()) {
                return "Error: Candidate Email is required!";
            }

            // 💾 Pre-store hrEmail on any existing draft or candidate record
            // (so the submission notification goes to the right HR)
            if (candidateMobile != null && !candidateMobile.isBlank()) {
                candidateRepository.findByPhone(candidateMobile).ifPresent(c -> {
                    c.setHrEmail(hrEmail);
                    candidateRepository.save(c);
                });
            }

            jakarta.mail.internet.MimeMessage mimeMessage = mailSender.createMimeMessage();
            org.springframework.mail.javamail.MimeMessageHelper helper = new org.springframework.mail.javamail.MimeMessageHelper(
                    mimeMessage, true, "UTF-8");

            helper.setTo(candidateEmail);
            helper.setSubject(agreementName);

            if (ccEmails != null && !ccEmails.trim().isEmpty()) {
                String[] ccArray = ccEmails.split(",");
                for (int i = 0; i < ccArray.length; i++) {
                    ccArray[i] = ccArray[i].trim();
                }
                helper.setCc(ccArray);
            }

            // Professional HTML email template
            String htmlContent = "<html><body style='font-family: Arial, sans-serif; line-height: 1.6; color: #333;'>" +
                    "<div style='max-width: 600px; margin: 0 auto; border: 1px solid #eee; padding: 20px; border-radius: 10px;'>"
                    +
                    "<div style='text-align: center; margin-bottom: 20px;'>" +
                    "<h1 style='color: #1c486e;'>Natco Pharma – HR Onboarding</h1>" +
                    "</div>" +
                    "<p>Hello,</p>" +
                    "<p>" + customMessage.replace("\n", "<br>") + "</p>" +
                    "<div style='text-align: center; margin: 30px 0;'>" +
                    "<a href='" + formLink
                    + "' style='background-color: #1c486e; color: white; padding: 14px 28px; text-decoration: none; border-radius: 8px; font-weight: bold; display: inline-block;'>Complete Onboarding Form</a>"
                    +
                    "</div>" +
                    "<p style='font-size: 13px; color: #666;'>If the button above doesn't work, copy and paste this link into your browser:<br>"
                    +
                    "<a href='" + formLink + "' style='color: #1c486e;'>" + formLink + "</a></p>" +
                    "<hr style='border: 0; border-top: 1px solid #eee; margin: 20px 0;'>" +
                    "<p style='font-size: 12px; color: #999;'>This is an automated message from the Natco HR Department. Please do not reply to this email.</p>"
                    +
                    "</div></body></html>";

            helper.setText(htmlContent, true);
            mailSender.send(mimeMessage);

            return "Mail sent successfully to " + candidateEmail;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending mail: " + e.getMessage();
        }
    }
}
