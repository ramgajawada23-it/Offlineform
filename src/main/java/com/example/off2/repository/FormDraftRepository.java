package com.example.off2.repository;

import com.example.off2.model.FormDraft;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormDraftRepository extends JpaRepository<FormDraft, Long> {
    Optional<FormDraft> findByMobile(String mobile);
}
