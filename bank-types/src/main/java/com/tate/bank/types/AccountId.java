package com.tate.bank.types;

import com.tate.bank.ddd.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author : tate
 * @date : 2022/12/6
 */
@Getter
@EqualsAndHashCode
@ToString
public class AccountId implements ValueObject {
    private final Long value;

    public AccountId(Long value) {
        this.value = value;
    }


}
