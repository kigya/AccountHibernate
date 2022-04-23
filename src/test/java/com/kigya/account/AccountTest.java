package com.kigya.account;

import com.kigya.account.entity.Account;
import com.kigya.account.entity.Gender;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class AccountTest {

    @Test
    @DisplayName("Should Create Account via Lombok Accessors")
    public void shouldCreateAccount() {
        Account account = new Account()
                .email("test@gmail.com")
                .password("Qwerty123!")
                .username("jdoe")
                .bio("Hey! My name is John Doe...")
                .gender(Gender.AGENDER)
                .country("USA")
                .city("New York")
                .streetAddress("1234 Independence Av.");
        Assertions.assertNotNull(account);
    }

    @Test
    @DisplayName("Should Create Account via Builder")
    public void shouldCreateAccountBuilder() {
        Account account = Account.newBuilder()
                .setEmail("test@gmail.com")
                .setPassword("Qwerty123!")
                .setUsername("jdoe")
                .setBio("Hey! My name is John Doe...")
                .setGender(Gender.AGENDER)
                .setCountry("USA")
                .setCity("New York")
                .setStreetAddress("1234 Independence Av.")
                .build();
        Assertions.assertNotNull(account);
    }

}
