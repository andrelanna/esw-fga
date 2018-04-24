package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class ParameterizedExampleWithoutConstructTests {
	
	@Parameter(value = 0)
	public int argument1;
	
	@Parameter(value = 1)
	public int expected;
    
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {2, 2},
        });
    }
	
	@Test
	public void someRandomTest(){
		assertEquals(argument1, expected);
	}

}
