package com.tate.bank.messaging;


import com.tate.bank.domain.types.AuditMessage;

/**
 * @author : tate
 * @date : 2022/12/6
 */
public interface AuditMessageProducer {
    boolean send(AuditMessage message);
}
