package com.tate.bank.web;

import com.tate.bank.application.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * @author : tate
 * @date : 2022/12/6
 */
@RestController
@RequestMapping(value = "/account")
public class TransferController {
    @Autowired
    private TransferService transferService;
    @PostMapping
    public boolean transfer(String targetAccountNumber, BigDecimal amount, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        userId = 1L;
        return transferService.transfer(userId, targetAccountNumber, amount, "CNY");
    }
}
