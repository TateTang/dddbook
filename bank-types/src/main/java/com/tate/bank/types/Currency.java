package com.tate.bank.types;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author : tate
 * @date : 2022/12/6
 */
@Getter
@EqualsAndHashCode
@ToString
public class Currency {
    private final String value;

    public Currency(String value) {
        this.value = value;
    }
}
