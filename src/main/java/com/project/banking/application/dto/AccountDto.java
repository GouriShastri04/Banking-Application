package com.project.banking.application.dto;

//import lombok.AllArgsConstructor; 
//import lombok.Data; 
//@Data 
//@AllArgsConstructor 

public class AccountDto { 

    private Long id; 
    private String accountHolderName; 
    private double balance; 

    // No-arg constructor 
    public AccountDto() { } 

    // All-arg constructor 
    public AccountDto(Long id, String accountHolderName, double balance) { 
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
