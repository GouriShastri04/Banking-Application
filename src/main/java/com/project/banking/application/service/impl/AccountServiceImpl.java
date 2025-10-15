package com.project.banking.application.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.banking.application.dto.AccountDto;
import com.project.banking.application.entity.Account;
import com.project.banking.application.entity.Transaction;
import com.project.banking.application.mapper.AccountMapper;
import com.project.banking.application.repository.AccountRepository;
import com.project.banking.application.repository.TransactionRepository;
import com.project.banking.application.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public AccountServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById (Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exIst."));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit (Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exIst."));
        
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

         // Create transaction
        Transaction transaction = new Transaction(
        "DEPOSIT",
        amount,
        LocalDateTime.now(),
        savedAccount
    );
    transactionRepository.save(transaction);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw (Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exIst."));
        
        if(account.getBalance() < amount) {
            throw new RuntimeException("Insufficient Amount!");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account saveAccount = accountRepository.save(account);

        // Save transaction
    Transaction transaction = new Transaction(
        "WITHDRAW",
        amount,
        LocalDateTime.now(),
        saveAccount
    );
    transactionRepository.save(transaction);

        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public List <AccountDto> getAllAccounts () {
        List <Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}