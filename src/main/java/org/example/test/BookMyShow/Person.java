package org.example.test.BookMyShow;

import java.time.LocalDate;
import java.util.UUID;

public class Person {
    private String userId;
    private String name;
    private String email;
    private LocalDate dob;
    private String mobile;

    public Person(String name, String email, LocalDate dob, String mobile) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.mobile = mobile;
        this.userId="USER-"+ UUID.randomUUID().toString().substring(0,9);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
