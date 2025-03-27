package com.vti.testing.service;

import com.vti.testing.entity.Account;
import com.vti.testing.form.AccountFilterForm;

import java.util.List;

public interface IAccountService {
    List<Account> getAll(AccountFilterForm form);
}
