package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaxNumberTest {

    MaxNumber m = new MaxNumber();

    @Test
    void testMax() {
        assertEquals(9, m.findMax(5,9,3));
    }

    @Test
    void testMax2() {
        assertEquals(10, m.findMax(10,4,7));
    }
}
