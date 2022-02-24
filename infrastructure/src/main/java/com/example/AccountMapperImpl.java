/*package com.example;

import java.util.ArrayList;
import java.util.List;

public class AccountMapperImpl implements AccountMapper{
    @Override
    public AccountEntity accountToAccountEntity(Account account) {
        return null;
    }

    @Override
    public Account accountEntityToAccount(AccountEntity accountEntity) {
        return null;
    }

    @Override
    public List<Account> listAccountEntityToListAccount(List<AccountEntity> listaccountEntity) {
        if (listaccountEntity == null) {
            return null;
        }

        List<Account> list = new ArrayList<Account>(listaccountEntity.size());
        for (AccountEntity accountEntity : listaccountEntity) {
            list.add(accountEntityToAccount(accountEntity));
        }

        return list;
    }
}*/
