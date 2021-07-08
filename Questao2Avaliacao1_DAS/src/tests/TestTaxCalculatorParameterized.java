package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;


@RunWith(Parameterized.class)
public class TestTaxCalculatorParameterized {


	@Parameter
	private float expected;
	@Parameter
	private Integer bandeira;
	@Parameter
	private float horas;
	@Parameter
	private float kmRodados;
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
			//{bandeira, km, horas, expected}
			{1, 100, 0, 290.24},
			{2, 100, 0, 371.24},
			{1, 50, 1, 179.46},
			{2, 50, 1, 219.96},
			{1, 30, 2, 154.18},
			{2, 30, 2, 178.48}
			
		});
	}
	
	public TestTaxCalculatorParameterized(int bandeira, float kmRodados, float horas, float expected) {
		this.bandeira = bandeira;
		this.expected = expected;
		this.kmRodados = kmRodados;
		this.horas = horas;
	}
	
	  @Test
	    public void test() {
	        assertEquals(expected, calculadoraDeTarifa.CalculadoraTarifaria.calculateTax(bandeira, kmRodados, horas));
	    }

}
