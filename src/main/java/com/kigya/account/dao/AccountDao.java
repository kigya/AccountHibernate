package com.kigya.account.dao;

import com.kigya.account.entity.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAll();
    void addItem(Account account);

}
