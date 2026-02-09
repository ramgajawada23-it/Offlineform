package com.example.off2.controller;

import com.example.off2.model.Draft;
import com.example.off2.repository.DraftRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/drafts")
@CrossOrigin(
    origins = {
        "http://127.0.0.1:5500",
        "http://localhost:5500",
        "https://ramgajawada23-it.github.io"
    }
)
public class DraftController {

    private final DraftRepository repo;

    public DraftController(DraftRepository repo) {
        this.repo = repo;
    }

    // SAVE / UPDATE DRAFT
    @PostMapping
    public void saveDraft(@RequestBody Draft incoming) {
        Draft draft = repo.findByMobile(incoming.getMobile())
                .orElse(new Draft());

        draft.setMobile(incoming.getMobile());
        draft.setData(incoming.getData());
        repo.save(draft);
    }

    // LOAD DRAFT BY MOBILE
    @GetMapping
    public Draft getDraft(@RequestParam String mobile) {
        return repo.findByMobile(mobile).orElse(null);
    }
}
