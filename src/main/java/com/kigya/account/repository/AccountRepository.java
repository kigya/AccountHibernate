package com.kigya.account.repository;

import com.kigya.account.dao.AccountDaoImpl;
import com.kigya.account.dao.AccountDatabase;
import com.kigya.account.entity.Account;

import java.util.List;
import java.util.Set;

public class AccountRepository {

    private final AccountDatabase ad = AccountDaoImpl::new;

    public List<Account> getAllAccounts() {
        return ad.getAccountDao().findAll();
    }

    public void addAccount(Account account) {
        ad.getAccountDao().addItem(account);
    }

    public Set<Integer> getIdSet() {
        return ad.getAccountDao().findAllId();
    }

    public Account getAccountById(int id) {
        return ad.getAccountDao().getById(id);
    }

}
