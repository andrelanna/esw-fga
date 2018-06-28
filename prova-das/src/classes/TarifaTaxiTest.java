package classes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TarifaTaxiTest {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {{ 1, 100, 0 }, { 2, 100, 0 }, { 1, 50, 1 }, { 2, 50, 1 }, { 1, 30, 2 }, {2, 30, 2}});
    }

    private float fInput;
    private float fExpected;

    public TarifaTaxiTest(float input, float expected) {
        fInput= input;
        fExpected= expected;
    }

    @Test
    public void test() {
//        assertEquals(fExpected, TarifaTaxi.calculaTarifa(fInput));
    }
}

