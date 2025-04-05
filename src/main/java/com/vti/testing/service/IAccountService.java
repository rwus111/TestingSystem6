package com.vti.testing.service;

import com.vti.testing.entity.Account;
import com.vti.testing.form.AccountCreatingForm;
import com.vti.testing.form.AccountFilterForm;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountService extends UserDetailsService {
    List<Account> getAll(AccountFilterForm form);

    void createAccount(AccountCreatingForm form);
}
