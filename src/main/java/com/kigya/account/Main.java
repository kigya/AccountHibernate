package com.kigya.account;

import com.kigya.account.entity.Account;
import com.kigya.account.entity.Gender;
import com.kigya.account.service.AccountDatabaseService;

public class Main {

    public static void main(String[] args) {
        AccountDatabaseService service = new AccountDatabaseService();

        Account account = Account.newBuilder()
                .setEmail("jdjdjdj@gmail.com")
                .setPassword("Wwhdbjhwd1!")
                .setUsername("tolik")
                .setBio("My name is shake shake shake")
                .setGender(Gender.GENDERFLUID)
                .setCountry("belarus")
                .setCity("sshshsh")
                .build();

        System.out.println(account);
    }

}
