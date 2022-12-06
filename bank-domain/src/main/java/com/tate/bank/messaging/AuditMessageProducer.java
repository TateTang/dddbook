package com.tate.bank.messaging;


import com.tate.bank.domain.types.AuditMessage;

/**
 * @author : maclstudio
 * @date : 2020/3/25
 */
public interface AuditMessageProducer {
    boolean send(AuditMessage message);
}
