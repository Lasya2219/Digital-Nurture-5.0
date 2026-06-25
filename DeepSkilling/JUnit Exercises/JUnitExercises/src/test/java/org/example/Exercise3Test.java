package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise3Test {

    @Test
    public void testAdd() {
        assertEquals(5, Exercise3.add(2,3));
    }

    @Test
    public void testSubtract() {
        assertEquals(5, Exercise3.subtract(7,2));
    }

    @Test
    public void testMultiply() {
        assertEquals(45, Exercise3.multiply(9,5));
    }

    @Test
    public void isGreater(){
        assertTrue(120>110);
    }

    @Test
    public void isLesser() {
        assertFalse(120<110);
    }

    @Test
    public void isNull() {
        assertNull(null);
    }

    @Test
    public void isNotNull() {
        assertNotNull(new Exercise3());
    }


}
