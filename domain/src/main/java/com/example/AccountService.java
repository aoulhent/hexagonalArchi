package com.example;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {

    void deposit(Account account, BigDecimal amount);
    void withraw(Account account, BigDecimal amount);
    void creerCompte(Account account);
    List<Account> listerComptes();
}
