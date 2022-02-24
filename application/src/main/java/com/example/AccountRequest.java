package com.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountRequest {

    private Account account;

    @JsonCreator
    public AccountRequest(@JsonProperty("account") Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
