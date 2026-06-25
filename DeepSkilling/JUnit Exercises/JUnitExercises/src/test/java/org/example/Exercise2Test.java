package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise2Test {
    @Test
    public void testadd() {
        assertEquals(5, Exercise2.add(2,3));
    }

    @Test
    public void testSubtract() {
        assertEquals(2, Exercise2.subtract(5,3));
    }
}
