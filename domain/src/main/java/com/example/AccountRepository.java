package com.example;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {

    Optional<Account> findById(Long accountId);
    void save(Account account);
    List<Account> findAll();
}
