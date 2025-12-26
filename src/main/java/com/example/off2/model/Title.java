// package com.example.off2.model;
 
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
 
// @Entity
// @Table(name = "title_master")
// public class Title {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Integer id;
 
//     private String code;
//     private String displayName;
//     private String gender;
 
//     // getters and setters
 
//     public Integer getId() {
//         return id;
//     }
 
//     public void setId(Integer id) {
//         this.id = id;
//     }
 
//     public String getCode() {
//         return code;
//     }
 
//     public void setCode(String code) {
//         this.code = code;
//     }
 
//     public String getDisplayName() {
//         return displayName;
//     }
 
//     public void setDisplayName(String displayName) {
//         this.displayName = displayName;
//     }
 
//     public String getGender() {
//         return gender;
//     }
 
//     public void setGender(String gender) {
//         this.gender = gender;
//     }
// }

// package com.example.off2.model;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "title_master")
// public class Title {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Integer id;

//     @Column(name = "display_name", nullable = false)
//     private String displayName;

//     // getters & setters
//     public Integer getId() { return id; }
//     public void setId(Integer id) { this.id = id; }

//     public String getDisplayName() { return displayName; }
//     public void setDisplayName(String displayName) { this.displayName = displayName; }
// }

package com.example.off2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "title_master")
public class Title {

    public Title() {} 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "display_name")
    private String displayName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}

