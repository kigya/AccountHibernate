package com.kigya.account.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Accessors(fluent = true)
@Entity
@Table(name = "credit_card", schema = "public", catalog = "accounts")
public class CreditCard {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "card_number", nullable = false)
    private long cardNumber;

    @Basic
    @Column(name = "card_type", nullable = false)
    private short cardType;

    @Basic
    @Column(name = "balance", nullable = false, precision = 3)
    private Double balance;

    @Basic
    @Column(name = "account_id", nullable = false)
    private int accountId;

    public static Account.@NotNull Builder newBuilder() {
        return new Account().new Builder();
    }

    public class Builder {
        protected Builder() {
        }

        public CreditCard.Builder setCardNumber(long cardNumber) {
            CreditCard.this.cardNumber = cardNumber;
            return this;
        }

        public CreditCard.Builder setCardType(short cardType) {
            CreditCard.this.cardType = cardType;
            return this;
        }

        public CreditCard.Builder setCardBalance(double balance) {
            CreditCard.this.balance = balance;
            return this;
        }

        public CreditCard.Builder setAccountId(int accountId) {
            CreditCard.this.accountId = accountId;
            return this;
        }

        public CreditCard build() {
            return CreditCard.this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return id == that.id && cardNumber == that.cardNumber && cardType == that.cardType && accountId == that.accountId && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber, cardType, balance, accountId);
    }
}
