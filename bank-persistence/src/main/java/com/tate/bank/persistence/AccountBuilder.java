package com.tate.bank.persistence;


import com.tate.bank.domain.entity.Account;
import com.tate.bank.types.*;
import org.springframework.stereotype.Component;

/**
 * @author : tate
 * @date : 2022/12/6
 */
@Component
public class AccountBuilder {
    public Account toAccount(AccountDO accountDO) {
        Currency currency = new Currency(accountDO.getCurrency());
        return new Account(new AccountId(accountDO.getId()), new AccountNumber(accountDO.getAccountNumber()),
                new UserId(accountDO.getId()), new Money(accountDO.getAvailable(), currency),
                new Money(accountDO.getDailyLimit(), currency));
    }

    public AccountDO fromAccount(Account account) {
        return new AccountDO(account.getId().getValue(), account.getAccountNumber().getValue(),
                account.getUserId().getId(), account.getAvailable().getValue(), account.getDailyLimit().getValue(), account.getCurrency().getValue());
    }
}
