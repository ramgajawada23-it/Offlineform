package com.example.off2.repository;

import com.example.off2.model.Draft;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DraftRepository extends JpaRepository<Draft, Long> {
    Optional<Draft> findByMobile(String mobile);
}
