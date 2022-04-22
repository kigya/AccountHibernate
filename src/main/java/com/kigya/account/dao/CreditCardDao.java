package com.kigya.account.dao;

import com.kigya.account.entity.CreditCard;

import java.util.List;

public interface CreditCardDao {

    List<CreditCard> findAll();
    void addItem(CreditCard creditCard);

}
