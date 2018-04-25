package tests;


import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class DependenteTests {

	@Parameter(value = 0)
	public float quantidade;
	
	@Parameter(value = 1)
	public float expected;
	
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10f, 10f, 1000f, 0f},
                {10f, 100f, 10f, 80f},
                {10f, 100f, 0f, 90f},
                {40f, 100f, 0f, 60f},
                {10f, 200f, 0f, 180f},
                {0f, 0f, 0f, 0f},
        });
    }
	
	@Test
	public void test() {
		assert(true);
	}

}
