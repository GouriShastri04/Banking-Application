package com.project.banking.application.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.banking.application.dto.AccountDto;
import com.project.banking.application.dto.TransactionDto;
import com.project.banking.application.service.AccountService;
import com.project.banking.application.service.TransactionService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;
    private final TransactionService transactionService;

    public AccountController(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    //ACCOUNT API
    //Add account REST Api
    @PostMapping
    public ResponseEntity <AccountDto> addAccount (@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //Get account rest api
    @GetMapping("/{id}")
    public ResponseEntity <AccountDto> getAccountById (@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    //Deposit rest api
    @PutMapping("/{id}/deposit")
    public ResponseEntity <AccountDto> deposit (@PathVariable Long id, @RequestBody Map <String, Double> request) {
        double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    //Withdraw rest api
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw (@PathVariable Long id, @RequestBody Map <String, Double> request) {
        double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    //Get all accounts rest api
    @GetMapping
    public ResponseEntity <List <AccountDto>> getAllAccounts() {
        List <AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    //Delete REST API
    @DeleteMapping("/{id}")
    public ResponseEntity <String> deleteAccount (@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account is deleted successfully!");
    }

    //TRANSACTION API
    //Get all transactions for a specific account
    @GetMapping("/{accountId}/transactions")
    public ResponseEntity<List<TransactionDto>> getTransactionsByAccountId(@PathVariable Long accountId) {
        List<TransactionDto> transactions = transactionService.getTransactionsByAccountId(accountId);
        return ResponseEntity.ok(transactions);
    }

    //Get all transactions (across all accounts)
    @GetMapping("/transactions/all")
    public ResponseEntity<List<TransactionDto>> getAllTransactions() {
        List<TransactionDto> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }
    
}
