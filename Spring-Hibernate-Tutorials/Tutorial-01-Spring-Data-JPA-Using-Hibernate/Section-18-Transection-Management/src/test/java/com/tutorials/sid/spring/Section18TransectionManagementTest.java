package com.tutorials.sid.spring;

import com.tutorials.sid.spring.entity.BankAccount;
import com.tutorials.sid.spring.services.IBankAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Unit test for simple Section18TransectionManagement.
 */
@SpringBootTest(classes = Section18TransectionManagement.class)
public class Section18TransectionManagementTest {

    @Autowired
    private IBankAccountService ibankAccountServices;

    @Test
    public void testApp() {
    }

    @Test
    public void testBankAccountTransactio() {
        BankAccount from = ibankAccountServices.save(BankAccount.builder().name("Sid-Sahu").balance(1000).build());
        BankAccount to = ibankAccountServices.save(BankAccount.builder().name("Sus-Sahoo").balance(500).build());
        ibankAccountServices.transactionAccount(from, to, 500);
    }
}
