package com.tate.bank.persistence;



import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author : tate
 * @date : 2022/12/6
 */
@Entity
@Table(name="account")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDO {
    @Id
    @GeneratedValue
    private Long id;
    private String accountNumber;
    private Long userId;
    private BigDecimal available;
    private BigDecimal dailyLimit;
    private String currency;


}
