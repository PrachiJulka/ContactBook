package com.ttn.contactbook.domain;

import javax.persistence.*;

@Entity
public class User {

    @Id @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int userId;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String email;
    private String password;
    private String photo;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
