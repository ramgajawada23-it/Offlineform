package com.example.off2.controller;

import com.example.off2.model.FormDraft;
import com.example.off2.repository.FormDraftRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/drafts")
@CrossOrigin(origins = {
        "http://127.0.0.1:5500",
        "http://localhost:5500",
        "https://offline-form-six.vercel.app"
})
public class FormDraftController {

    private final FormDraftRepository repo;

    public FormDraftController(FormDraftRepository repo) {
        this.repo = repo;
    }

    // ================= SAVE / UPDATE DRAFT =================
    @PostMapping
    public ResponseEntity<?> saveDraft(@RequestBody FormDraft incoming) {

        if (incoming.getMobile() == null || incoming.getMobile().isBlank()) {
            return ResponseEntity.badRequest().body("Mobile is required");
        }

        FormDraft draft = repo.findByMobile(incoming.getMobile())
                .orElse(new FormDraft());

        draft.setMobile(incoming.getMobile());
        draft.setFormData(incoming.getFormData());

        repo.save(draft);
        return ResponseEntity.ok().build();
    }

    // ================= LOAD DRAFT BY MOBILE =================
    @GetMapping
    public ResponseEntity<FormDraft> getDraft(@RequestParam String mobile) {

        return repo.findByMobile(mobile)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }
}
