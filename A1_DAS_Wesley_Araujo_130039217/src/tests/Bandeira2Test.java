package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import das.a1.Bandeira2;

@RunWith(Parameterized.class)
public class Bandeira2Test {
	Bandeira2 bandeira2;
	
	@Parameter(value = 0)
	Double expected;
	
	@Parameter(value = 1)
	Double kmRodado;
	
	@Parameter(value = 2)
	Double horasParadas;
	
	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {371.24, 100.0, 0.0}
        });
    }
	
	@Before
	public void setUp() throws Exception {
		bandeira2 = new Bandeira2();
	}

	@Test
	public void testValorTotal() {
		Assert.assertEquals(expected, bandeira2.calculaValorTotal(kmRodado, horasParadas), 0.0);
	}

}
