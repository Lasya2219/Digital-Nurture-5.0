package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise4Test {

    private Exercise4 ex4;

    @Before
    public void setUp() {
        ex4 = new Exercise4();
        System.out.println("Setup executed");
    }

    @After
    public void tearDown() {
        ex4 = null;
        System.out.print("Tear Down executed");
    }

    @Test
    public void test(){
        assertEquals(20, Exercise4.Multiply(5,4));
    }
}
