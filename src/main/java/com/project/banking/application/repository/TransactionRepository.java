package com.project.banking.application.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.banking.application.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountId(Long accountId);
}
