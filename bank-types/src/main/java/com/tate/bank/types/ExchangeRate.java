package com.tate.bank.types;


import com.tate.bank.ddd.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author : tate
 * @date : 2022/12/6
 */
@Getter
@EqualsAndHashCode
@ToString
public class ExchangeRate implements ValueObject {
    private final BigDecimal foreignExchange;
    private final Currency source;
    private final Currency target;

    public ExchangeRate(BigDecimal foreignExchange, Currency source, Currency target) {
        this.foreignExchange = foreignExchange;
        this.source = source;
        this.target = target;
    }


    public Money exchangeTo(Money targetMoney) {
        BigDecimal sourceAmount = targetMoney.getValue().divide(foreignExchange, RoundingMode.DOWN);
        return new Money(sourceAmount, target);
    }
}
