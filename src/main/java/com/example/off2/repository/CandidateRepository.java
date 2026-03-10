
package com.example.off2.repository;

import com.example.off2.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    boolean existsByPhone(String phone);

    Optional<Candidate> findByPhone(String phone);
}
