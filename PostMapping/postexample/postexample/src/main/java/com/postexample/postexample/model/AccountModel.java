package com.postexample.postexample.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AccountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accNo;
    private String name;
    public AccountModel() {
    }
    public AccountModel(int accNo, String name) {
        this.accNo = accNo;
        this.name = name;
    }
    public int getAccNo() {
        return accNo;
    }
    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
}
