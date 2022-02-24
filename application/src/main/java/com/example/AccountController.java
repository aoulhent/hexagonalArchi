package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void creerCompte(@RequestBody AccountRequest accountRequest){
        accountService.creerCompte(accountRequest.getAccount());
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountResponse listerCompte(){
        AccountResponse accountResponse = new AccountResponse(accountService.listerComptes());
        return accountResponse;
    }

    @PostMapping(value = "/deposite", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void depsiteAmount(@RequestBody AccountRequest accountRequest){
        accountService.deposit(accountRequest.getAccount(), accountRequest.getAccount().getAmount());
    }
}
