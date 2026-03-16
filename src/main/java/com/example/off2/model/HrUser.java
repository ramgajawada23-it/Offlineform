package com.example.off2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hr_users")
public class HrUser {

    @Id
    private String username;
    private String password;
    private String empName;

    public HrUser() {}

    public HrUser(String username, String password, String empName) {
        this.username = username;
        this.password = password;
        this.empName = empName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
