// package com.example.off2.model;

// import jakarta.persistence.*;
// import java.time.LocalDate;

// @Entity
// @Table(name = "candidate")
// public class Candidate {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String aadhaar;

//     @Column(name = "bank_account")
//     private String bankAccount;

//     private String city;
//     private LocalDate dob;
//     private String email;

//     @Column(name = "full_name")
//     private String fullName;

//     private String gender;
//     private String phone;
//     private String state;

//     // MANY candidates → ONE title
//     @ManyToOne
//     @JoinColumn(name = "title_id")
//     private Title title;

//     // Getters & setters
//     public Long getId() { return id; }

//     public String getFullName() { return fullName; }
//     public void setFullName(String fullName) { this.fullName = fullName; }

//     public Title getTitle() { return title; }
//     public void setTitle(Title title) { this.title = title; }

//     public LocalDate getDob() { return dob; }
//     public void setDob(LocalDate dob) { this.dob = dob; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getPhone() { return phone; }
//     public void setPhone(String phone) { this.phone = phone; }

//     public String getGender() { return gender; }
//     public void setGender(String gender) { this.gender = gender; }

//     public String getState() { return state; }
//     public void setState(String state) { this.state = state; }

//     public String getCity() { return city; }
//     public void setCity(String city) { this.city = city; }

//     public String getAadhaar() { return aadhaar; }
//     public void setAadhaar(String aadhaar) { this.aadhaar = aadhaar; }

//     public String getBankAccount() { return bankAccount; }
//     public void setBankAccount(String bankAccount) { this.bankAccount = bankAccount; }
// }

package com.example.off2.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "candidate")
public class Candidate {

    public Candidate() {} 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;
    private String email;
    private String phone;
    private String gender;
    private String state;
    private String city;
    private String aadhaar;
    
    @Column(name = "bank_account")
    private String bankAccount;

    private LocalDate dob;
    @ManyToOne
    @JoinColumn(name = "title_id")
    private Title title;

    // getters & setters
    public Long getId() { return id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getAadhaar() { return aadhaar; }
    public void setAadhaar(String aadhaar) { this.aadhaar = aadhaar; }

    public String getBankAccount() { return bankAccount; }
    public void setBankAccount(String bankAccount) { this.bankAccount = bankAccount; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public Title getTitle() { return title; }
    public void setTitle(Title title) { this.title = title; }
}

