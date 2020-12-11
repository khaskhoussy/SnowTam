package com.example.snowtam;

import androidx.annotation.NonNull;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;


public class UsersDataBase {
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    private String password;

    public UsersDataBase() {
    }

    public UsersDataBase(String id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    void saveUser(UsersDataBase user) {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NonNull
    @Override
    public String toString() {
        return "id :" + this.id + " userName : " + this.firstName + " lastName : " + this.lastName + " Email : " + this.email + " password :" + this.password;
    }
}
