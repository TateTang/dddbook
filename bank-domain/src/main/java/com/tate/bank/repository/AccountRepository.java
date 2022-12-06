package com.tate.bank.repository;


import com.tate.bank.ddd.Repository;
import com.tate.bank.domain.entity.Account;
import com.tate.bank.types.AccountId;
import com.tate.bank.types.AccountNumber;
import com.tate.bank.types.UserId;

/**
 * @author : maclstudio
 * @date : 2020/3/25
 */
public interface AccountRepository extends Repository {
    Account find(AccountId id);
    Account find(AccountNumber accountNumber);
    Account find(UserId userId);
    Account save(Account account);
}
