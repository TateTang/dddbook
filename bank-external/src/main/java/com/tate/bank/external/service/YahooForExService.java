package com.tate.bank.external.service;

import com.tate.bank.types.Currency;

import java.math.BigDecimal;

/**
 * @author : tate
 * @date : 2022/12/6
 */
public interface YahooForExService {
    BigDecimal getExchangeRate(Currency sourceCurrency, Currency targetCurrency);
}
