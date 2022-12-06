package com.tate.bank.repository.impl;


import com.tate.bank.domain.entity.Account;
import com.tate.bank.persistence.AccountDO;
import com.tate.bank.repository.AccountRepository;
import com.tate.bank.types.AccountId;
import com.tate.bank.types.AccountNumber;
import com.tate.bank.types.UserId;
import com.tate.bank.persistence.AccountBuilder;
import com.tate.bank.persistence.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : maclstudio
 * @date : 2020/3/25
 */
@Component
public class AccountRepositoryImpl implements AccountRepository {
    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private AccountBuilder accountBuilder;


    @Override
    public Account find(AccountId id) {
        AccountDO accountDO = accountDAO.findById(id.getValue()).get();
        return accountBuilder.toAccount(accountDO);
    }

    @Override
    public Account find(AccountNumber accountNumber) {
        AccountDO accountDO = accountDAO.findByAccountNumber(accountNumber.getValue());
        return accountBuilder.toAccount(accountDO);
    }

    @Override
    public Account find(UserId userId) {
        AccountDO accountDO = accountDAO.findByUserId(userId.getId());
        return accountBuilder.toAccount(accountDO);
    }

    @Override
    public Account save(Account account) {
        AccountDO accountDO = accountBuilder.fromAccount(account);
        accountDAO.saveAndFlush(accountDO);
        return accountBuilder.toAccount(accountDO);
    }
}
