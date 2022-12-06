package com.tate.bank.external;

import com.tate.bank.types.Currency;
import com.tate.bank.types.ExchangeRate;

/**
 * @author : tate
 * @date : 2022/12/6
 */
public interface ExchangeRateService {
    ExchangeRate getExchangeRate(Currency source, Currency target);
}
