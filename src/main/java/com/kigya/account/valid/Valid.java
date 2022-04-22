package com.kigya.account.valid;

import com.kigya.account.entity.CardType;
import com.kigya.account.entity.Gender;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.EnumUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Valid {

    private static final String EMAIL_REGEX_PATTERN =
            "^([\\w-.]+){1,40}@([\\w&&[^_]]+){2,20}.[a-z]{2,}$";
    private static final String PASSWORD_REGEX_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,200}$";
    private static final String USERNAME_REGEX_PATTERN =
            "^[\\w-.]{4,32}$";
    private static final String BIO_REGEX_PATTERN =
            "^[\\s\\S]*{0,256}$";
    private static final String CITY_REGEX_PATTERN =
            "^[\\w-.]{2,36}$";
    private static final String COUNTRY_REGEX_PATTERN =
            "^[\\w-.]{4,36}$";
    private static final String STREET_ADDRESS_REGEX_PATTERN =
            "[0-9]+[ |[a-zà-ú.,-]([ .,-]*[a-zà-ú0-9]*)*";
    private static final String CARD_NUMBER_REGEX_PATTERN =
            "^[\\d-.]{12,20}$";

    @Contract(pure = true)
    public static boolean isValidEmail(@NotNull String string) {
        return valid(string, EMAIL_REGEX_PATTERN);
    }

    @Contract(pure = true)
    public static boolean isValidPassword(@NotNull String string) {
        return valid(string, PASSWORD_REGEX_PATTERN);
    }

    @Contract(pure = true)
    public static boolean isValidUsername(@NotNull String string) {
        return valid(string, USERNAME_REGEX_PATTERN);
    }

    @Contract(pure = true)
    public static boolean isValidBio(@NotNull String string) {
        return valid(string, BIO_REGEX_PATTERN);
    }

    @Contract(pure = true)
    public static boolean isValidGender(@NotNull Gender gender) {
        return EnumUtils.isValidEnum(Gender.class, gender.toString());
    }

    @Contract(pure = true)
    public static boolean isValidCity(@NotNull String string) {
        return valid(string, CITY_REGEX_PATTERN);
    }

    @Contract(pure = true)
    public static boolean isValidCountry(@NotNull String string) {
        return valid(string, COUNTRY_REGEX_PATTERN);
    }

    @Contract(pure = true)
    public static boolean isValidStreetAddress(@NotNull String string) {
        return valid(string, STREET_ADDRESS_REGEX_PATTERN);
    }

    @Contract(pure = true)
    public static boolean isValidCardAccountId(int id) {
        // TODO implement database query selection accounts id and check it
        return true;
    }

    @Contract(pure = true)
    public static boolean isValidBalance(@NotNull Double value) {
        return value >= 0.0;
    }

    @Contract(pure = true)
    public static boolean isValidCardType(@NotNull CardType cardType) {
        return EnumUtils.isValidEnum(CardType.class, cardType.toString());
    }

    @Contract(pure = true)
    public static boolean isValidCardNumber(@NotNull String string) {
        return valid(string, CARD_NUMBER_REGEX_PATTERN);
    }

    private static boolean valid(@NotNull String string, String pattern) {
        return !string.isBlank() && string.matches(pattern);
    }

}
