package com.project.banking.application.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.project.banking.application.entity.Account; 

public interface AccountRepository extends JpaRepository<Account, Long> { }