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
@CrossOrigin(
    origins = {
        "http://127.0.0.1:5500",
        "http://localhost:5500",
        "https://offline-form-six.vercel.app"
    },
    allowedHeaders = "*",
    methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE,
        RequestMethod.OPTIONS
    }
)


public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    // ================= CREATE Candidate + Family =================
    @PostMapping
@Transactional
public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate)
{

        // 🔗 Ensure bidirectional mapping
        if (candidate.getFamilyMembers() != null) {
            for (FamilyMember member : candidate.getFamilyMembers()) {
                member.setCandidate(candidate);
            }
        }

        Candidate savedCandidate = candidateService.saveCandidate(candidate);
        return new ResponseEntity<>(savedCandidate, HttpStatus.CREATED);
    }

    // ================= GET ALL Candidates (MASKED RESPONSE) =================
    @GetMapping
    public ResponseEntity<List<CandidateResponseDTO>> getAllCandidates() {
        return ResponseEntity.ok(candidateService.getAllCandidates());
    }

    // ================= GET Candidate by ID (MASKED RESPONSE) =================
    @GetMapping("/{id}")
    public ResponseEntity<CandidateResponseDTO> getCandidateById(@PathVariable Long id) {
        return ResponseEntity.ok(candidateService.getCandidateById(id));
    }
}
