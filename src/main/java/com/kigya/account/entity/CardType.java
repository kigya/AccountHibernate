package com.kigya.account.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Accessors(fluent = true)
public enum CardType {

    DINERS_CLUB_INTERNATIONAL((short) 1),
    MAESTRO((short) 2),
    JCB((short) 3),
    DINERS_CLUB_ENROUTE((short) 4),
    INSTAPAYMENT((short) 5),
    SWITCH((short) 6),
    BANKCARD((short) 7),
    MASTERCARD((short) 8),
    DINERS_CLUB_CARTE_BLANCHE((short) 9),
    VISA((short) 10),
    AMERICANEXPRESS((short) 11),
    LASER((short) 12),
    SOLO((short) 13),
    DINERS_CLUB_US_CA((short) 14),
    CHINA_UNIONPAY((short) 15),
    VISA_ELECTRON((short) 16);

    private final short value;

}
