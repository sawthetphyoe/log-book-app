package com.example.logbookapp;

import java.io.Serializable;
import java.util.Date;

public class Contact implements Serializable {
    private long _id; //primary key
    private String name;
    private String email;
    private String dob;

    public Contact(String name, String email, String dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Contact(long id, String name, String email, String dob) {
        this._id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        this._id = id;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
