package com.project.banking.application.dto;

import java.time.LocalDateTime;

public class TransactionDto {
    private Long id;
    private String type;
    private double amount;
    private LocalDateTime timestamp;
    private Long accountId;

    public TransactionDto() {}

    public TransactionDto(Long id, String type, double amount, LocalDateTime timestamp, Long accountId) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
        this.accountId = accountId;
    }

    public Long getId() { return id; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public Long getAccountId() { return accountId; }

    public void setId(Long id) { this.id = id; }
    public void setType(String type) { this.type = type; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public void setAccountId(Long accountId) { this.accountId = accountId; }
}
