package com.example.off2.service;

import com.example.off2.dto.CandidateResponseDTO;
import com.example.off2.model.Candidate;

import java.util.List;

public interface CandidateService {

    Candidate saveCandidate(Candidate candidate);

    List<CandidateResponseDTO> getAllCandidates();

    CandidateResponseDTO getCandidateById(Long id);
}
