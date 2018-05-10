package com.hbfintech.pay.trade.service.bank;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hbfintech.pay.trade.PayTradeApplication;
import com.hbfintech.pay.trade.domain.bank.BankBo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PayTradeApplication.class)
@TestPropertySource("/pay-trade-test.properties")
public class BankServiceTest
{
    @Autowired
    BankBo bankService;

    @Test
    public void testIsBankClosed() {
        assertTrue(bankService.isBankOpen("ICBC"));
    }
}

