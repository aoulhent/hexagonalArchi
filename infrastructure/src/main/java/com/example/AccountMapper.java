package com.example;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountEntity accountToAccountEntity(Account account);
    Account accountEntityToAccount(AccountEntity accountEntity);
    List<Account> listAccountEntityToListAccount(List<AccountEntity> listaccountEntity);
}
