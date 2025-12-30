package com.example.off2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "family_member")
public class FamilyMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String relationship;
    private String name;
    private LocalDate dob;
    private String dependent;
    private String occupation;
    private Double income;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false)
    @JsonBackReference
    private Candidate candidate;

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public String getRelationship() {
        return relationship;
    }
    
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }
    
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getDependent() {
        return dependent;
    }
    
    public void setDependent(String dependent) {
        this.dependent = dependent;
    }

    public String getOccupation() {
        return occupation;
    }
    
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Double getIncome() {
        return income;
    }
    
    public void setIncome(Double income) {
        this.income = income;
    }

    public Candidate getCandidate() {
        return candidate;
    }
    
    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
