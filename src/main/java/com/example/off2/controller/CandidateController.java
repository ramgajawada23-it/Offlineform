package com.example.off2.controller;

import com.example.off2.model.Candidate;
import com.example.off2.model.Title;
import com.example.off2.repository.CandidateRepository;
import com.example.off2.repository.TitleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
@CrossOrigin(origins = "*")
public class CandidateController {

    private final CandidateRepository candidateRepository;
    private final TitleRepository titleRepository;

    public CandidateController(CandidateRepository candidateRepository,
            TitleRepository titleRepository) {
        this.candidateRepository = candidateRepository;
        this.titleRepository = titleRepository;
    }

    // @PostMapping
    // public Candidate addCandidate(@RequestBody Candidate candidate) {

    // System.out.println("TITLE RECEIVED: " + candidate.getTitle());

    // if (candidate.getTitle() != null && candidate.getTitle().getId() != null) {
    // Title title = titleRepository.findById(candidate.getTitle().getId())
    // .orElseThrow(() -> new RuntimeException("Title not found"));
    // candidate.setTitle(title);
    // }

    // return candidateRepository.save(candidate);
    // }

    @PostMapping
    public Candidate addCandidate(@RequestBody Candidate candidate) {

        if (candidate.getTitle() == null || candidate.getTitle().getId() == null) {
            throw new RuntimeException("Title is required");
        }

        Title title = titleRepository.findById(candidate.getTitle().getId())
                .orElseThrow(() -> new RuntimeException("Title not found"));

        candidate.setTitle(title);
        return candidateRepository.save(candidate);
    }

    @GetMapping
    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }
}
