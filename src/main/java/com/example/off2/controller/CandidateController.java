// package com.example.off2.controller;
 
// import com.example.off2.model.Candidate;
// import com.example.off2.repository.CandidateRepository;
// import org.springframework.web.bind.annotation.*;
 
// import java.util.List;
 
// @RestController
// @RequestMapping("/candidates")
// @CrossOrigin(origins = "*")
// public class CandidateController {
 
//     private final CandidateRepository repository;
 
//     public CandidateController(CandidateRepository repository) {
//         this.repository = repository;
//     }
 
//     @GetMapping
//     public List<Candidate> getAllCandidates() {
//         return repository.findAll();
//     }
 
//     @PostMapping
//     public Candidate addCandidate(@RequestBody Candidate candidate) {
//         return repository.save(candidate);
//     }
 
//     @GetMapping("/{id}")
//     public Candidate getCandidateById(@PathVariable Long id) {
//         return repository.findById(id).orElse(null);
//     }
// }


// package com.example.off2.controller;

// import com.example.off2.model.Candidate;
// import com.example.off2.model.Title;
// import com.example.off2.repository.CandidateRepository;
// import com.example.off2.repository.TitleRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.Optional;

// @RestController
// @RequestMapping("/candidates")
// public class CandidateController {

//     @Autowired
//     private CandidateRepository candidateRepository;

//     @Autowired
//     private TitleRepository titleRepository;

//     @PostMapping
//     public Candidate addCandidate(@RequestBody CandidateRequest request) {
//         Candidate candidate = new Candidate();
//         candidate.setFullName(request.getFullName());
//         candidate.setEmail(request.getEmail());
//         candidate.setPhone(request.getPhone());
//         candidate.setDob(request.getDob());
//         candidate.setGender(request.getGender());
//         candidate.setState(request.getState());
//         candidate.setCity(request.getCity());
//         candidate.setAadhaar(request.getAadhaar());
//         candidate.setBankAccount(request.getBankAccount());

//         // Fetch Title entity by ID
//         Optional<Title> titleOpt = titleRepository.findById(request.getTitleId());
//         titleOpt.ifPresent(candidate::setTitle);

//         return candidateRepository.save(candidate);
//     }
// }

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

    @PostMapping
    public Candidate addCandidate(@RequestBody Candidate candidate) {

        System.out.println("TITLE RECEIVED: " + candidate.getTitle());

        if (candidate.getTitle() != null && candidate.getTitle().getId() != null) {
            Title title = titleRepository.findById(candidate.getTitle().getId())
                    .orElseThrow(() -> new RuntimeException("Title not found"));
            candidate.setTitle(title);
        }

        return candidateRepository.save(candidate);
    }

    @GetMapping
    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }
}

