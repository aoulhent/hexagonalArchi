package com.example;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void deposit(Account account, BigDecimal amount) {
        Optional<Account> optionalAccount = accountRepository.findById(account.getId());
        if(optionalAccount.isPresent())
        {
            Account acc =  optionalAccount.get();
            BigDecimal balance = acc.getBalance().add(amount);
            acc.setBalance(balance);
            accountRepository.save(acc);
        }
    }

    @Override
    public void withraw(Account account, BigDecimal amount) {
        Optional<Account> optionalAccount = accountRepository.findById(account.getId());
        if(optionalAccount.isPresent())
        {
            Account acc =  optionalAccount.get();
            BigDecimal balance = acc.getBalance().subtract(amount);
            acc.setBalance(balance);
            accountRepository.save(acc);
        }
    }

    @Override
    public void creerCompte(Account account) {
        accountRepository.save(account);
    }

    @Override
    public List<Account> listerComptes() {
        return accountRepository.findAll();
    }
}
