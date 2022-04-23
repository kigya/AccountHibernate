package com.kigya.account.dao;

import com.kigya.account.entity.Account;

import java.util.List;
import java.util.Set;

public interface AccountDao {

    List<Account> findAll();

    void addItem(Account account);

    Set<Integer> findAllId();

    Account getById(int id);

}
