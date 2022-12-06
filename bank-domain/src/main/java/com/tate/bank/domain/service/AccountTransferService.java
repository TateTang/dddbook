package com.tate.bank.domain.service;

import com.tate.bank.domain.entity.Account;
import com.tate.bank.types.ExchangeRate;
import com.tate.bank.types.Money;

/**
 * @author : maclstudio
 * @date : 2020/3/26
 */
public interface AccountTransferService {
    void transfer(Account sourceAccount, Account targetAccount, Money targetMoney, ExchangeRate exchangeRate);
}
