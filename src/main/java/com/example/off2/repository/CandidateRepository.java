// package com.example.off2.repository;
 
// import com.example.off2.model.Candidate;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
 
// @Repository
// public interface CandidateRepository extends JpaRepository<Candidate, Long> {
// }


// package com.example.off2.repository;

// import com.example.off2.model.Candidate;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository
// public interface CandidateRepository extends JpaRepository<Candidate, Long> { }

package com.example.off2.repository;

import com.example.off2.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
