package com.kigya.account.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

@SuppressWarnings("unused")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Formatter {

    public static @NotNull String lowercaseWords(@NotNull String str) {
        return str.toLowerCase(Locale.ROOT).trim();
    }

    public static @NotNull String trim(@NotNull String str) {
        return str.toLowerCase(Locale.ROOT).trim();
    }

}
