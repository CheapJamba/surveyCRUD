package com.bagandov.surveyCRUD.db.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FilterDTO {

    String field;

    ValueType valueType;

    String value;

    public enum ValueType {
        STRING, DATE, BOOLEAN
    }

}
