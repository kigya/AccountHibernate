package com.kigya.account.repository;

import com.kigya.account.dao.AccountDaoImpl;
import com.kigya.account.dao.AccountDatabase;
import com.kigya.account.dao.CreditCardDaoImpl;
import com.kigya.account.dao.CreditCardDatabase;
import com.kigya.account.entity.Account;
import com.kigya.account.entity.CreditCard;

import java.util.List;

public class CreditCardRepository {
    private final CreditCardDatabase ad = CreditCardDaoImpl::new;

    public List<CreditCard> getAllCreditCards() {
        return ad.getCreditCardDao().findAll();
    }

    public void addCreditCard(CreditCard creditCard) {
        ad.getCreditCardDao().addItem(creditCard);
    }
}
