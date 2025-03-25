package com.example.account.repository;

import com.example.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface    AccountRepository extends JpaRepository<Account, Long> {
    Account findById(String id);
    List<Account> findAll();

}
