package com.example.account.service;

import com.example.account.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account findById(String id);
    void createAccount(Account account);
    void updatePassword(String id, String newPassword);
    boolean checkPassword(String id, String password);
    void deleteById(String id);
}
