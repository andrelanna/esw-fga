package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class ParameterizedExampleTests {
	
	private int argument1;
    public int expected;
    
    public ParameterizedExampleTests(int a, int exp){
    	this.argument1 = a;
    	this.expected = exp;
    }
    
	
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
