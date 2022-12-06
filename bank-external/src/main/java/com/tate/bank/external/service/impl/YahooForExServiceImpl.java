package com.tate.bank.external.service.impl;

import com.tate.bank.external.service.YahooForExService;
import com.tate.bank.types.Currency;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author : tate
 * @date : 2022/12/6
 */
@Component
public class YahooForExServiceImpl implements YahooForExService {

    @Override
    public BigDecimal getExchangeRate(Currency sourceCurrency, Currency targetCurrency) {
        return BigDecimal.ONE;
    }
}
