package com.kigya.account.service;

import com.kigya.account.entity.Account;
import com.kigya.account.repository.AccountRepository;
import com.kigya.account.utils.Extensions;
import com.kigya.account.valid.Valid;
import lombok.experimental.ExtensionMethod;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;

@ExtensionMethod({Extensions.class})
public class AccountDatabaseService {

    private final AccountRepository repository = new AccountRepository();

    public List<Account> getAll() {
        return repository.getAllAccounts();
    }

    public boolean addAccount(@NotNull Account account) {

        format(account);

        if (!Valid.isValidEmail(account.email())) {
            return false;
        }

        if (!Valid.isValidPassword(account.password())) {
            return false;
        }

        if (!Valid.isValidUsername(account.username())) {
            return false;
        }

        if (account.bio() != null && !Valid.isValidBio(account.bio())) {
            return false;
        }

        if (!Valid.isValidGender(account.gender())) {
            return false;
        }

        if (!Valid.isValidCountry(account.country())) {
            return false;
        }

        if (account.city() != null && !Valid.isValidCity(account.city())) {
            return false;
        }

        return account.streetAddress() == null ||
                Valid.isValidStreetAddress(account.streetAddress());

    }

    private void format(@NotNull Account account){
        account.email(account.email()
                .toLowerCase(Locale.ROOT)
                .trim());

        account.password(account.password()
                .trim());

        account.username(account.username()
                .toLowerCase(Locale.ROOT)
                .trim());

        if (account.bio() != null) {
            account.bio(account.bio()
                    .trim());
        }

        account.country(account.country()
                .uppercaseFirst()
                .trim());

        if (account.city() != null) {
            account.city(account.city()
                    .uppercaseFirst()
                    .trim());
        }

        if (account.streetAddress() != null) {
            account.streetAddress(account.streetAddress()
                    .trim());
        }
    }
}
