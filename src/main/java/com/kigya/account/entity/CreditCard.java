package com.kigya.account.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
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
    private String cardNumber;

    @Basic
    @Column(name = "card_type", nullable = false)
    private CardType cardType;

    @Basic
    @Column(name = "balance", nullable = false, precision = 3)
    private double balance;

    @Basic
    @Column(name = "account_id", nullable = false)
    private int accountId;

    public static Account.@NotNull Builder newBuilder() {
        return new Account().new Builder();
    }

    public class Builder {
        protected Builder() {
        }

        public CreditCard.Builder setCardNumber(String cardNumber) {
            CreditCard.this.cardNumber = cardNumber;
            return this;
        }

        public CreditCard.Builder setCardType(CardType cardType) {
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
}
