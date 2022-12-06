package com.tate.bank.application;



import com.tate.bank.ddd.ApplicationService;

import java.math.BigDecimal;

/**
 * @author : tate
 * @date : 2022/12/6
 */
public interface TransferService extends ApplicationService {
    boolean transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) ;
}
