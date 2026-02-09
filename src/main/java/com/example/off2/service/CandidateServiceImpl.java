package com.example.off2.service;

import com.example.off2.dto.CandidateResponseDTO;
import com.example.off2.model.Candidate;
import com.example.off2.repository.CandidateRepository;
import com.example.off2.util.MaskUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository repository;

    public CandidateServiceImpl(CandidateRepository repository) {
        this.repository = repository;
    }

    @Override
    public Candidate saveCandidate(Candidate candidate) {

        if (candidate.getFamilyMembers() != null) {
            candidate.getFamilyMembers()
                    .forEach(f -> f.setCandidate(candidate));
        }

        if (candidate.getEducations() != null) {
            candidate.getEducations()
                    .forEach(e -> e.setCandidate(candidate));
        }

        return repository.save(candidate);
    }

    @Override
    public List<CandidateResponseDTO> getAllCandidates() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
public CandidateResponseDTO getCandidateById(Long id) {
  if (id == null) {
    throw new IllegalArgumentException("Id cannot be null");
  }

        Candidate candidate = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
        return mapToDTO(candidate);
    }

    private CandidateResponseDTO mapToDTO(Candidate c) {
        CandidateResponseDTO dto = new CandidateResponseDTO();
        dto.setId(c.getId());
        dto.setFullName(c.getFullName());
        dto.setEmail(c.getEmail());
        dto.setPhone(c.getPhone());
        dto.setGender(c.getGender());
        dto.setState(c.getState());
        dto.setCity(c.getCity());
        dto.setDob(c.getDob());

        // 🔐 MASK HERE
        dto.setAadhaar(MaskUtil.maskAadhaar(c.getAadhaar()));
        dto.setBankAccount(MaskUtil.maskBankAccount(c.getBankAccount()));

        dto.setFamilyMembers(c.getFamilyMembers());
        return dto;
    }
}
