package com.tate.bank.types;

import com.tate.bank.ddd.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author : tate
 * @date : 2022/12/6
 */
@EqualsAndHashCode
@Getter
@ToString
public class Money implements ValueObject, Comparable {
    private final BigDecimal value;
    private final Currency currency;

    public Money(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public Money add(Money money) {
        return new Money(value.add(money.value), currency);
    }

    @Override
    public int compareTo(Object o) {
        return value.compareTo(((Money)o).getValue());
    }

    public Money subtract(Money money) {
        return new Money(value.subtract(money.value), currency);
    }


}
