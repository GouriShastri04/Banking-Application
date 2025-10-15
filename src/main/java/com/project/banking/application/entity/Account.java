package com.project.banking.application.entity;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import jakarta.persistence.Table; 
//import lombok.AllArgsConstructor; 
//import lombok.Getter; 
//import lombok.NoArgsConstructor; 
//import lombok.Setter; 

@Entity 
@Table(name = "Accounts") 
//@Getter 
//@Setter 
//@NoArgsConstructor 
//@AllArgsConstructor 

public class Account { 

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 

    @Column(name = "account_holder_name") 
    private String accountHolderName; 
    
    private double balance; 
    
    // No-arg constructor 
    public Account() { } 
    
    // All-arg constructor 
    public Account(Long id, String accountHolderName, double balance) { 
        this.id = id; 
        this.accountHolderName = accountHolderName; 
        this.balance = balance; 
    } 

    // Getters 
    public Long getId() { 
        return id; 
    } 
    
    public String getAccountHolderName() { 
        return accountHolderName; 
    } 
    
    public double getBalance() { 
        return balance; 
    } 
    
    // Setters 
    public void setId(Long id) { 
        this.id = id; 
    } 
    
    public void setAccountHolderName(String accountHolderName) { 
        this.accountHolderName = accountHolderName; 
    } 
    
    public void setBalance(double balance) { 
        this.balance = balance; 
    } 

}