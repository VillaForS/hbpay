package com.hbfintech.pay.trade.service.bank;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hbfintech.pay.trade.PayTradeApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PayTradeApplication.class)
@TestPropertySource("/pay-trade-test.properties")
public class BankServiceTest
{
}

