package com.example.off2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "drafts")
public class Draft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String mobile;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String data;

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
