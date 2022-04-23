package com.kigya.account;

import com.kigya.account.entity.Account;
import com.kigya.account.entity.Gender;
import com.kigya.account.service.AccountDatabaseService;

public class Main {
    public static void main(String[] args) {
        AccountDatabaseService service = new AccountDatabaseService();
        Account account = new Account().email("test@gmail.com")
                .password("dhdhHH11!")
                .username("hdhdh")
                .gender(Gender.NON_BINARY)
                .country("belarus");
        service.addAccount(account);
    }
}
