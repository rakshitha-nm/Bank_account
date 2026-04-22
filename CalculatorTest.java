package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, calc.add(2,3));
    }

    @Test
    public void testSubtract() {
        assertEquals(2, calc.subtract(5,3));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calc.multiply(5,3));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calc.divide(6,3));
    }
    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calc.divide(5,0);
    }
}
