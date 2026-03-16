package com.example.off2.repository;

import com.example.off2.model.HrUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HrUserRepository extends JpaRepository<HrUser, String> {
    Optional<HrUser> findByUsernameAndPassword(String username, String password);
}
