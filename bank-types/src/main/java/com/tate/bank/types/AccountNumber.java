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
public class AccountNumber implements ValueObject {
    private final String value;

    public AccountNumber(String value) {
        this.value = value;
    }


}
