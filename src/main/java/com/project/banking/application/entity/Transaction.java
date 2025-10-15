package com.project.banking.application.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // "DEPOSIT" or "WITHDRAW"
    private double amount;

    private LocalDateTime timestamp;

    // Many transactions can belong to one account
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    // Default constructor
    public Transaction() {
    }

    // All-args constructor
    public Transaction(String type, double amount, LocalDateTime timestamp, Account account) {
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
        this.account = account;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Account getAccount() {
        return account;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
