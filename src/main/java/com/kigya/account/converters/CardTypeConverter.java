package com.kigya.account.converters;

import com.kigya.account.entity.CardType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class CardTypeConverter implements AttributeConverter<CardType, Short> {

    @Override
    public Short convertToDatabaseColumn(CardType gender) {
        return gender == null ? null : gender.value();
    }

    @Override
    public CardType convertToEntityAttribute(Short code) {
        return code == null ? null : Stream.of(CardType.values())
                .filter(c -> c.value() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}