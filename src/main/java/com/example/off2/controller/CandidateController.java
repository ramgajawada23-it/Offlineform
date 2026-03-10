package com.example.off2.controller;

import com.example.off2.dto.CandidateResponseDTO;
import com.example.off2.model.Candidate;
import com.example.off2.model.FamilyMember;
import com.example.off2.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    // ================= CREATE Candidate =================
    @PostMapping
    @Transactional
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
        if (candidate.getFamilyMembers() != null) {
            for (FamilyMember member : candidate.getFamilyMembers()) {
                member.setCandidate(candidate);
            }
        }
        Candidate savedCandidate = candidateService.saveCandidate(candidate);
        return new ResponseEntity<>(savedCandidate, HttpStatus.CREATED);
    }

    // ================= GET ALL Candidates =================
    @GetMapping
    public ResponseEntity<List<CandidateResponseDTO>> getAllCandidates() {
        return ResponseEntity.ok(candidateService.getAllCandidates());
    }

    // ================= GET Candidate by ID =================
    @GetMapping("/{id}")
    public ResponseEntity<CandidateResponseDTO> getCandidateById(@PathVariable Long id) {
        return ResponseEntity.ok(candidateService.getCandidateById(id));
    }

    // ================= GET Candidate by Phone (for HR review) =================
    @GetMapping("/by-phone/{phone}")
    public ResponseEntity<?> getCandidateByPhone(@PathVariable String phone) {
        return candidateService.findByPhone(phone)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ================= UPDATE CTC Review (HR only) =================
    @PutMapping("/{id}/ctc")
    public ResponseEntity<Candidate> updateCtc(@PathVariable Long id, @RequestBody Candidate ctcData) {
        Candidate updated = candidateService.updateCandidateCtc(id, ctcData);
        return ResponseEntity.ok(updated);
    }
}
