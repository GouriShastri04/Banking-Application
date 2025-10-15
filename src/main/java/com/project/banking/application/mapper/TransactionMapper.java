package com.project.banking.application.mapper;

import com.project.banking.application.dto.TransactionDto;
import com.project.banking.application.entity.Transaction;

public final class TransactionMapper {

    private TransactionMapper() {} 

    public static TransactionDto mapToTransactionDto(Transaction transaction) {
        return new TransactionDto(
            transaction.getId(),
            transaction.getType(),
            transaction.getAmount(),
            transaction.getTimestamp(),
            transaction.getAccount().getId()
        );
    }
}
