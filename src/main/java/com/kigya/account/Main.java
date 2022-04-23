package com.kigya.account;

import com.kigya.account.entity.Account;
import com.kigya.account.entity.Gender;
import com.kigya.account.service.AccountDatabaseService;
import com.kigya.account.service.CreditCardDatabaseService;
import com.kigya.account.valid.Valid;

public class Main {

    public static void main(String[] args) {
        CreditCardDatabaseService service = new CreditCardDatabaseService();

        Account account = Account.newBuilder()
                .setEmail("jdjdjdj@gmail.com")
                .setPassword("Wwhdbjhwd1!")
                .setUsername("tolik")
                .setBio("My name is shake shake shake")
                .setGender(Gender.GENDERFLUID)
                .setCountry("belarus")
                .setCity("sshshsh")
                .build();

        System.out.println(service.getCreditCardByAccountId(2));
    }

}
