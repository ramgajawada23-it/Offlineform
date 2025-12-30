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

    public CandidateController(
            CandidateRepository candidateRepository,
            TitleRepository titleRepository) {
        this.candidateRepository = candidateRepository;
        this.titleRepository = titleRepository;
    }

    // ===== POST : Save Candidate + Family =====
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

    // ===== GET : Fetch All Candidates with Family =====
    @GetMapping
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    // ===== GET : Fetch Single Candidate =====
    @GetMapping("/{id}")
    public Candidate getCandidateById(@PathVariable Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
    }
}



// package com.example.off2.controller;

// import com.example.off2.model.Candidate;
// import com.example.off2.model.Title;
// import com.example.off2.repository.CandidateRepository;
// import com.example.off2.repository.TitleRepository;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/candidates")
// @CrossOrigin(origins = "*")
// public class CandidateController {

//     private final CandidateRepository candidateRepository;
//     private final TitleRepository titleRepository;

//     public CandidateController(CandidateRepository candidateRepository,
//             TitleRepository titleRepository) {
//         this.candidateRepository = candidateRepository;
//         this.titleRepository = titleRepository;
//     }

//     @PostMapping
//     public Candidate addCandidate(@RequestBody Candidate candidate) {

//         if (candidate.getTitle() == null || candidate.getTitle().getId() == null) {
//             throw new RuntimeException("Title is required");
//         }

//         Title title = titleRepository.findById(candidate.getTitle().getId())
//                 .orElseThrow(() -> new RuntimeException("Title not found"));

//         candidate.setTitle(title);
//         return candidateRepository.save(candidate);
//     }

//     @GetMapping
//     public List<Candidate> getAll() {
//         return candidateRepository.findAll();
//     }
// }
