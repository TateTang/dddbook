package com.tate.bank.types;

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
public class UserId {
    private final Long id;

    public UserId(Long id) {
        this.id = id;
    }
}
