package com.kigya.account.converters;

import com.kigya.account.entity.Gender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, Short> {

    @Override
    public Short convertToDatabaseColumn(Gender gender) {
        return gender == null ? null : gender.value();
    }

    @Override
    public Gender convertToEntityAttribute(Short code) {
        return code == null ? null : Stream.of(Gender.values())
                .filter(c -> c.value() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}