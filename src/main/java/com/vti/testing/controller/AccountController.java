package com.vti.testing.controller;

import com.vti.testing.dto.AccountDTO;
import com.vti.testing.entity.Account;
import com.vti.testing.form.AccountFilterForm;
import com.vti.testing.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<AccountDTO> getAll(AccountFilterForm form) {
        List<Account> accounts = accountService.getAll(form);
        return modelMapper.map(accounts, new TypeToken<List<AccountDTO>>() {
        }.getType());
    }
}
