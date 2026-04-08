package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    BankAccount acc = new BankAccount();

    @Test
    void testDeposit() {

        acc.deposit(1000);

        assertEquals(1000, acc.getBalance());
    }

    @Test
    void testWithdraw() {

        acc.deposit(1000);

        acc.withdraw(200);

        assertEquals(800, acc.getBalance());
    }
}
