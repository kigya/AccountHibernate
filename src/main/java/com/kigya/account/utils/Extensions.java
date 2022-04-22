package com.kigya.account.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Extensions {

    public static @NotNull String uppercaseFirst(@NotNull String s) {
        if (s.isEmpty()) {
            return s;
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public static @NotNull String deleteWhitespaces(@NotNull String s) {
        return s.replace(" ", "").trim();
    }

    public static @NotNull Double setStandartPrecision(Double value) {
        double scale = Math.pow(10, 3);
        return Math.round(value * scale) / scale;
    }

}
