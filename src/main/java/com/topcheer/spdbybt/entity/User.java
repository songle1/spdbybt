package com.topcheer.spdbybt.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private String username;
    private String sex;
    private String address;
    private String password;
    private String score;

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    private String bankcode;



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPassword(String password)  {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setScore(String score) {
        this.score=score;
    }
    public String getScore(){
        return this.score;
    }



}