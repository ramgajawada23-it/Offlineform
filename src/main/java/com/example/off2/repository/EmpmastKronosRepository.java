package com.example.off2.repository;

import com.example.off2.model.EmpmastKronos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpmastKronosRepository extends JpaRepository<EmpmastKronos, String> {
    Optional<EmpmastKronos> findByEmpCodeAndPassword(String empCode, String password);
}
