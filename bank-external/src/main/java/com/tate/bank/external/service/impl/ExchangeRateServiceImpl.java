package com.tate.bank.external.service.impl;

import com.tate.bank.types.Currency;
import com.tate.bank.types.ExchangeRate;
import com.tate.bank.external.ExchangeRateService;
import com.tate.bank.external.service.YahooForExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author : maclstudio
 * @date : 2020/3/26
 */
@Component
public class ExchangeRateServiceImpl implements ExchangeRateService {
    @Autowired
    private YahooForExService yahooForexService;

    @Override
    public ExchangeRate getExchangeRate(Currency source, Currency target) {
        if (source.equals(target)) {
            return new ExchangeRate(BigDecimal.ONE, source, target);
        }
        BigDecimal foreignExchange = yahooForexService.getExchangeRate(source, target);
        return new ExchangeRate(foreignExchange, source, target);
    }
}
