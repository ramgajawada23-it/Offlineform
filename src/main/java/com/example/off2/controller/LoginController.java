package com.example.off2.controller;

import com.example.off2.model.FormDraft;
import com.example.off2.repository.FormDraftRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final FormDraftRepository draftRepo;

    public LoginController(FormDraftRepository draftRepo) {
        this.draftRepo = draftRepo;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String mobile = body.get("mobile");
        if (mobile == null || mobile.isBlank()) {
            return ResponseEntity.badRequest().body("Mobile number is required");
        }

        Map<String, Object> response = new HashMap<>();
        Optional<FormDraft> draftOpt = draftRepo.findByMobile(mobile);

        if (draftOpt.isPresent()) {
            response.put("status", "DRAFT");
            response.put("draft", draftOpt.get());
        } else {
            // In this specific system, absence of a draft means it's a NEW user/form
            response.put("status", "NEW");
        }

        return ResponseEntity.ok(response);
    }
}
