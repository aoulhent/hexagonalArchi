package com.example;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class AccountJpaRespository implements AccountRepository {

    private SpringDataAccountRepository springDataAccountRepository;

    public AccountJpaRespository(SpringDataAccountRepository springDataAccountRepository) {
        this.springDataAccountRepository = springDataAccountRepository;
    }

    @Override
    public Optional<Account> findById(Long accountId) {
        Optional<AccountEntity> account = springDataAccountRepository.findById(accountId);
        if(account.isPresent()){
            AccountEntity accountEntity = account.get();
            Account a = AccountMapper.INSTANCE.accountEntityToAccount(accountEntity);
            return Optional.ofNullable(a);
        }
        return Optional.empty();
    }

    @Override
    public void save(Account account) {
        AccountEntity accountEntity = AccountMapper.INSTANCE.accountToAccountEntity(account);
        springDataAccountRepository.save(accountEntity);
    }

    @Override
    public List<Account> findAll() {
        List<AccountEntity> accountEntities = StreamSupport.stream(springDataAccountRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        //List<Account> accounts = accountEntities.stream().map(e -> AccountMapper.INSTANCE.accountEntityToAccount(e)).collect(Collectors.toList());
        return AccountMapper.INSTANCE.listAccountEntityToListAccount(accountEntities);
    }
}
