package com.kigya.account.repository;

import com.kigya.account.dao.AccountDaoImpl;
import com.kigya.account.dao.AccountDatabase;
import com.kigya.account.entity.Account;

import java.util.List;

public class AccountRepository {

    private final AccountDatabase ad = AccountDaoImpl::new;

    public List<Account> getAllAccounts() {
        return ad.getAccountDao().findAll();
    }

    public void addApplicant(Account account) {
        ad.getAccountDao().addItem(account);
    }

}
