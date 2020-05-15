package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

//import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import das.a1.Bandeira1;
import exceptions.BandeiraException;

@RunWith(Parameterized.class)
public class Bandeira1Test {
	
	static Bandeira1 bandeira1;
	
	@Parameter(value = 0)
	public Double valueExpected;
	
	@Parameter(value = 1)
	public Double kmRodado;
	
	@Parameter(value = 2)
	public Double horasParadas;
	
	@Parameters 
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {290.24, 100.0, 0.0}, // Exceção
                {179.46, 50.0, 1.0},
                {154.18, 30.0, 2.0}
        });
    }
	
	@Before
	public void setUp() throws Exception {
		bandeira1 = new Bandeira1();
	}

	@Test
	public void testValorTotal() {
		assertEquals(valueExpected, bandeira1.calculaValorTotal(kmRodado, horasParadas), 0.00);
	}
	
//	@Test(expected = BandeiraException.class)
//	public void testBandeiraNula() {
//		
//	}

}
