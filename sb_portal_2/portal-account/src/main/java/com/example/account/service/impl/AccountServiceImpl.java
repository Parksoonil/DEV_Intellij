package com.example.account.service.impl;

import com.example.account.entity.Account;
import com.example.account.repository.AccountRepository;
import com.example.account.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    public AccountServiceImpl(AccountRepository accountRepository) { this.accountRepository = accountRepository; }

    @Override
    public void updatePassword(String id, String newPassword) {
        Account account = accountRepository.findById(id);
        if(account != null) {
            account.setPassword(newPassword);
            accountRepository.save(account);
        } else {
            throw new RuntimeException();
        }
    }
    @Override
    public void createAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account findById(String id) {
        return accountRepository.findById(id);
    }
    @Override
    public boolean checkPassword(String id, String password) {
        Account account = accountRepository.findById(id);
        if(account != null) {
            return account.getPassword().equals(password);
        } else {
            return false;
        }
    }
    @Override
    public void deleteById(String id) {
       Account account = accountRepository.findById(id);
       accountRepository.delete(account);
    }
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
