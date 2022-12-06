package com.tate.bank.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author : tate
 * @date : 2022/12/6
 */
@Component
public interface AccountDAO extends JpaRepository<AccountDO, Long> {
    Optional<AccountDO> findById(Long value);

    AccountDO findByAccountNumber(String value);

    AccountDO findByUserId(Long id);

    AccountDO saveAndFlush(AccountDO accountDO);

}
