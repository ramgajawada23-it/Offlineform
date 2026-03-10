package com.example.off2.service;

import com.example.off2.dto.CandidateResponseDTO;
import com.example.off2.model.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateService {

    Candidate saveCandidate(Candidate candidate);

    List<CandidateResponseDTO> getAllCandidates();

    CandidateResponseDTO getCandidateById(Long id);

    Candidate updateCandidateCtc(Long id, Candidate ctcData);

    Optional<Candidate> findByPhone(String phone);
}
