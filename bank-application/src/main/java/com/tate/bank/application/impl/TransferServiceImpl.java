package com.tate.bank.application.impl;


import com.tate.bank.types.*;
import com.tate.bank.application.TransferService;
import com.tate.bank.domain.entity.Account;
import com.tate.bank.domain.service.AccountTransferService;
import com.tate.bank.domain.types.AuditMessage;
import com.tate.bank.external.ExchangeRateService;
import com.tate.bank.messaging.AuditMessageProducer;
import com.tate.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author : tate
 * @date : 2022/12/6
 */
@Component
public class TransferServiceImpl implements TransferService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AuditMessageProducer auditMessageProducer;
    @Autowired
    private ExchangeRateService exchangeRateService;
    @Autowired
    private AccountTransferService accountTransferService;

    @Transactional
    @Override
    public boolean transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) {
        // 参数校验
        Money targetMoney = new Money(targetAmount, new Currency(targetCurrency));
        UserId userId = new UserId(sourceUserId);
        // 读数据
        Account sourceAccount = accountRepository.find(userId);
        Account targetAccount = accountRepository.find(new AccountNumber(targetAccountNumber));
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(sourceAccount.getCurrency(), targetMoney.getCurrency());

        // 业务逻辑
        accountTransferService.transfer(sourceAccount, targetAccount, targetMoney, exchangeRate);

        // 保存数据
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        // 发送审计消息
        AuditMessage message = new AuditMessage(userId, sourceAccount, targetAccount, targetMoney);
        auditMessageProducer.send(message);

        return true;
    }
}
