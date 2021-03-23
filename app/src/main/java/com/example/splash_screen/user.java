package com.example.splash_screen;

public class user {

    String name1;
    String email1;
    String pass1;




    public user(String name1, String email1, String pass1) {
        this.name1 = name1;
        this.email1 = email1;
        this.pass1 = pass1;
    }

    public user() {
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getPass1() {
        return pass1;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }
}

