package com.kigya.account.service;

import com.kigya.account.entity.CreditCard;
import com.kigya.account.repository.CreditCardRepository;
import com.kigya.account.utils.Extensions;
import com.kigya.account.valid.Valid;
import lombok.experimental.ExtensionMethod;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@ExtensionMethod({Extensions.class})
public class CreditCardDatabaseService {

    private final CreditCardRepository repository = new CreditCardRepository();

    public List<CreditCard> getAll() {
        return repository.getAllCreditCards();
    }

    public boolean addCreditCard(@NotNull CreditCard creditCard) {

        boolean check = true;
        format(creditCard);

        if (!Valid.isValidCardNumber(creditCard.cardNumber())) {
            check = false;
        }

        if (!Valid.isValidBalance(creditCard.balance())) {
            check = false;
        }

        if (!Valid.isValidCardType(creditCard.cardType())) {
            check = false;
        }

        if (!Valid.isValidCardAccountId(creditCard.accountId())) {
            check = false;
        }

        if (check) {
            repository.addCreditCard(creditCard);
            return true;
        } else {
            return false;
        }

    }

    private void format(@NotNull CreditCard creditCard) {
        creditCard.cardNumber(creditCard.cardNumber()
                .deleteWhitespaces());

        creditCard.balance(Double.valueOf(creditCard.balance())
                .setStandartPrecision());
    }

    public CreditCard getCreditCardById(int id) {
        return repository.getCreditCardById(id);
    }

    public List<CreditCard> getCreditCardByAccountId(int id) {
        return repository.getCreditCardsByAccountId(id);
    }



}
