package com.kigya.account.service;

import com.kigya.account.entity.Account;
import com.kigya.account.repository.AccountRepository;
import com.kigya.account.utils.Extensions;
import com.kigya.account.valid.Valid;
import lombok.experimental.ExtensionMethod;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;
import java.util.Set;

@SuppressWarnings("unused")
@ExtensionMethod({Extensions.class})
public class AccountDatabaseService {

    private final AccountRepository repository = new AccountRepository();

    public List<Account> getAll() {
        return repository.getAllAccounts();
    }

    public boolean addAccount(@NotNull Account account) {

        boolean check = true;

        format(account);

        if (!Valid.isValidEmail(account.email())) {
            check = false;
        }

        if (!Valid.isValidPassword(account.password())) {
            check = false;
        }

        if (!Valid.isValidUsername(account.username())) {
            check = false;
        }

        if (account.bio() != null && !Valid.isValidBio(account.bio())) {
            check = false;
        }

        if (!Valid.isValidGender(account.gender())) {
            check = false;
        }

        if (!Valid.isValidCountry(account.country())) {
            check = false;
        }

        if (account.city() != null && !Valid.isValidCity(account.city())) {
            check = false;
        }

        if (account.streetAddress() != null &&
                !Valid.isValidStreetAddress(account.streetAddress())) {
            check = false;
        }

        if (check) {
            repository.addAccount(account);
            return true;
        } else {
            return false;
        }

    }

    public Set<Integer> getAllId() {
        return repository.getIdSet();
    }

    public Account getAccountById(int id) {
        return repository.getAccountById(id);
    }

    private void format(@NotNull Account account) {
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
