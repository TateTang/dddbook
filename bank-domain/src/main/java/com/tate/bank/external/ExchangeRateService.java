package com.tate.bank.external;

import com.tate.bank.types.Currency;
import com.tate.bank.types.ExchangeRate;

/**
 * @author : maclstudio
 * @date : 2020/3/26
 */
public interface ExchangeRateService {
    ExchangeRate getExchangeRate(Currency source, Currency target);
}
