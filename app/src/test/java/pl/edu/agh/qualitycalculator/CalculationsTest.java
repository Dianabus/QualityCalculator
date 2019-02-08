package pl.edu.agh.qualitycalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculationsTest {
    Calculations calculationsUnderTest;

    @Before
    public void setUp() {
        calculationsUnderTest = new Calculations();
    }

    @Test
    public void testSum() throws Exception {
        assertEquals(5, calculationsUnderTest.calculate(Operation.SUM, 2, 3), 0.01);
    }

    @Test
    public void testSubtract()throws Exception{
        assertEquals(11f, calculationsUnderTest.calculate(Operation.SUBTRACT,1000, 989));
    }

    @Test
    public void testMult() throws Exception {
        assertEquals(35f, calculationsUnderTest.calculate(Operation.MULTIPLY, 5, 7));
    }

    @Test
    public void testDivide() throws Exception {
        assertEquals(4f, calculationsUnderTest.calculate(Operation.DIVIDE, 8, 2));
    }



    @After
    public void tearDown() {
        calculationsUnderTest = null;
        System.gc();
    }
}
