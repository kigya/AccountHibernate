package com.kigya.account.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Accessors(fluent = true)
public enum Gender {

    MALE((short) 1),
    FEMALE((short) 2),
    NON_BINARY((short) 3),
    GENDERQUEER((short) 4),
    GENDERFLUID((short) 5),
    BIGENDER((short) 6),
    AGENDER((short) 7),
    POLYGENDER((short) 8);

    private final short value;

}
