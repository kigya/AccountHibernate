package com.kigya.account.service;

import com.kigya.account.entity.CreditCard;
import com.kigya.account.repository.CreditCardRepository;
import com.kigya.account.utils.Extensions;
import com.kigya.account.valid.Valid;
import lombok.experimental.ExtensionMethod;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@SuppressWarnings("unused")
@ExtensionMethod({Extensions.class})
public class CreditCardDatabaseService {

    private final CreditCardRepository repository = new CreditCardRepository();

    public List<CreditCard> getAll() {
        return repository.getAllCreditCards();
    }

    public boolean updateCreditCard(CreditCard creditCard) {
        format(creditCard);

        if (check(creditCard)) {
            repository.updateCreditCard(creditCard);
            return true;
        } else {
            return false;
        }
    }

    public boolean addCreditCard(@NotNull CreditCard creditCard) {

        format(creditCard);

        if (check(creditCard)) {
            repository.addCreditCard(creditCard);
            return true;
        } else {
            return false;
        }

    }

    private boolean check(@NotNull CreditCard creditCard) {
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
                .setStandardPrecision());
    }

    public CreditCard getCreditCardById(int id) {
        return repository.getCreditCardById(id);
    }

    public List<CreditCard> getCreditCardsByAccountId(int id) {
        return repository.getCreditCardsByAccountId(id);
    }

    public boolean makeTransfer(@NotNull CreditCard from, CreditCard to, double amount) {
        if (from.balance() >= amount) {
            from.balance(from.balance() - amount);
            to.balance(to.balance() + amount);
            repository.updateCreditCard(from);
            repository.updateCreditCard(to);
            return true;
        } else {
            return false;
        }
    }

}
