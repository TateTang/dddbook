package com.tate.bank.domain.entity;

import com.tate.bank.ddd.Entity;
import com.tate.bank.exception.InvalidCurrencyException;
import com.tate.bank.types.*;
import com.tate.bank.exception.DailyLimitExceededException;
import com.tate.bank.exception.InsufficientFundsException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : tate
 * @date : 2022/12/6
 */
@Getter
@AllArgsConstructor
public class Account implements Entity {
    private AccountId id;
    private AccountNumber accountNumber;
    private UserId userId;
    private Money available;
    private Money dailyLimit;

    public Currency getCurrency() {
        return this.available.getCurrency();
    }

    // 转入
    public void deposit(Money money) {
        if (!this.getCurrency().equals(money.getCurrency())) {
            throw new InvalidCurrencyException();
        }
        this.available = this.available.add(money);
    }

    // 转出
    public void withdraw(Money money) {
        if (this.available.compareTo(money) < 0) {
            throw new InsufficientFundsException();
        }
        if (this.dailyLimit.compareTo(money) < 0) {
            throw new DailyLimitExceededException();
        }
        this.available = this.available.subtract(money);
    }
}
