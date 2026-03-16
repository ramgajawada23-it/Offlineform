package com.example.off2.controller;

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
    private final com.example.off2.repository.CandidateRepository candidateRepo;
    private final com.example.off2.repository.EmpmastKronosRepository empRepo;
    private final com.example.off2.repository.HrUserRepository hrUserRepo;

    public LoginController(FormDraftRepository draftRepo,
            com.example.off2.repository.CandidateRepository candidateRepo,
            com.example.off2.repository.EmpmastKronosRepository empRepo,
            com.example.off2.repository.HrUserRepository hrUserRepo) {
        this.draftRepo = draftRepo;
        this.candidateRepo = candidateRepo;
        this.empRepo = empRepo;
        this.hrUserRepo = hrUserRepo;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String mobile = body.get("mobile");
        if (mobile == null || mobile.isBlank()) {
            return ResponseEntity.badRequest().body("Mobile number is required");
        }

        Map<String, Object> response = new HashMap<>();
        if (candidateRepo.existsByPhone(mobile)) {
            response.put("status", "SUBMITTED");
        } else {
            Optional<com.example.off2.model.FormDraft> draftOpt = draftRepo.findByMobile(mobile);
            if (draftOpt.isPresent()) {
                response.put("status", "DRAFT");
                response.put("draft", draftOpt.get());
            } else {
                response.put("status", "NEW");
            }
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/hr")
    public ResponseEntity<?> hrLogin(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        if (username == null || password == null) {
            return ResponseEntity.badRequest().body("Username and password are required");
        }

        // Try local HR table first
        Optional<com.example.off2.model.HrUser> hrOpt = hrUserRepo.findByUsernameAndPassword(username, password);
        if (hrOpt.isPresent()) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("empName", hrOpt.get().getEmpName());
            response.put("empCode", hrOpt.get().getUsername());
            return ResponseEntity.ok(response);
        }

        // Fallback to legacy Empmast table
        return empRepo.findByEmpCodeAndPassword(username, password)
                .map(emp -> {
                    Map<String, Object> response = new HashMap<>();
                    response.put("success", true);
                    response.put("empName", emp.getEmpName());
                    response.put("empCode", emp.getEmpCode());
                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.status(401).body(Map.of("success", false, "message", "Invalid credentials")));
    }

    @PostMapping("/hr/signup")
    public ResponseEntity<?> hrSignup(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        String empName = body.get("empName");

        if (username == null || password == null || empName == null) {
            return ResponseEntity.badRequest().body("All fields are required");
        }

        if (hrUserRepo.existsById(username)) {
            return ResponseEntity.status(409).body(Map.of("success", false, "message", "Username already exists"));
        }

        com.example.off2.model.HrUser newUser = new com.example.off2.model.HrUser(username, password, empName);
        hrUserRepo.save(newUser);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "User registered successfully");
        return ResponseEntity.ok(response);
    }
}
