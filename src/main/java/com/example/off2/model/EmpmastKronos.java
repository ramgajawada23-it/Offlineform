package com.example.off2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPMAST_Kronos", catalog = "NATCO_ESS")
public class EmpmastKronos {

    @Id
    @Column(name = "EMP_CODE")
    private String empCode;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMP_NAME")
    private String empName;

    // Default constructor
    public EmpmastKronos() {}

    // Getters and Setters
    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
