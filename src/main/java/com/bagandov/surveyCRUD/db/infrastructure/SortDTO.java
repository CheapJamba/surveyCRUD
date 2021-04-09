package com.bagandov.surveyCRUD.db.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SortDTO {

    private String property;

    private String order;
}
