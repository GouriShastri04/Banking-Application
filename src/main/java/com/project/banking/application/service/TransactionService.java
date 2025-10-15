package com.project.banking.application.service;

import java.util.List;
import com.project.banking.application.dto.TransactionDto;

public interface TransactionService {
    List<TransactionDto> getTransactionsByAccountId(Long accountId);
    List<TransactionDto> getAllTransactions();
}