package com.kigya.account.service;

import com.kigya.account.entity.Account;
import com.kigya.account.entity.CreditCard;
import com.kigya.account.repository.AccountRepository;
import com.kigya.account.repository.CreditCardRepository;
import com.kigya.account.utils.Extensions;
import com.kigya.account.valid.Valid;
import lombok.experimental.ExtensionMethod;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;

@ExtensionMethod({Extensions.class})
public class CreditCardDatabaseService {

    private final CreditCardRepository repository = new CreditCardRepository();

    public List<CreditCard> getAll() {
        return repository.getAllCreditCards();
    }

    public boolean addCreditCard(@NotNull CreditCard creditCard) {

        format(creditCard);

        if (!Valid.isValidCardNumber(creditCard.cardNumber())) {
            return false;
        }

        if (!Valid.isValidBalance(creditCard.balance())) {
            return false;
        }

        if (!Valid.isValidCardType(creditCard.cardType())) {
            return false;
        }

        return Valid.isValidCardAccountId(creditCard.accountId());
    }

    private void format(@NotNull CreditCard creditCard) {
        creditCard.cardNumber(creditCard.cardNumber()
                .deleteWhitespaces());

        creditCard.balance(Double.valueOf(creditCard.balance())
                .setStandartPrecision());
    }

}
