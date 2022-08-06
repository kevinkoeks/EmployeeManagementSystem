package com.kevcompany.employeeManager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity //Database
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id; //primairyKey
    private String name;
    private String email;
    private String jobTitle;
    private String phoneNr;
    private String imageUrl;
    @Column(nullable = false,updatable = false) //will count for the line below it
    private String codeForEmployee;

    public Employee() {
    }

    public Employee(String name, String email, String jobTitle, String phoneNr, String imageUrl, String codeForEmployee) {
        this.name = name;
        this.email = email;
        this. jobTitle = jobTitle;
        this.phoneNr = phoneNr;
        this.imageUrl = imageUrl;
        this.codeForEmployee = codeForEmployee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCodeForEmployee() {
        return codeForEmployee;
    }

    public void setCodeForEmployee(String codeForEmployee) {
        this.codeForEmployee = codeForEmployee;
    }

    @Override
    public String toString() { //if item needs to be printed out
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phoneNr='" + phoneNr + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", codeForEmployee='" + codeForEmployee + '\'' +
                '}';
    }
}
