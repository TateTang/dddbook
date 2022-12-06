package com.tate.bank.domain.service.impl;

import com.tate.bank.domain.entity.Account;
import com.tate.bank.domain.service.AccountTransferService;
import com.tate.bank.external.ExchangeRateService;
import com.tate.bank.types.ExchangeRate;
import com.tate.bank.types.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : tate
 * @date : 2022/12/6
 */
@Component
public class AccountTransferServiceImpl implements AccountTransferService {
    @Autowired
    private ExchangeRateService exchangeRateService;

    @Override
    public void transfer(Account sourceAccount, Account targetAccount, Money targetMoney, ExchangeRate exchangeRate) {
        Money sourceMoney = exchangeRate.exchangeTo(targetMoney);
        sourceAccount.deposit(sourceMoney);
        targetAccount.withdraw(targetMoney);

    }
}
