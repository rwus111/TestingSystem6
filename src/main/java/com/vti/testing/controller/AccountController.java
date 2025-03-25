package com.vti.testing.controller;

import com.vti.testing.entity.Account;
import com.vti.testing.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping
    public List<Account> getAll() {
        // TODO migrate to DTO
        return accountService.getAll();
    }
}
