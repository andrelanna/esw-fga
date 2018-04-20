package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.parameterized.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import src.*;


@RunWith(Parameterized.class)
public class ParameterizedTaxesTests {

	@Parameter(value = 0)
	public BandeiraTypes flag;
	
	@Parameter(value = 1)
	public double kmRun;
	
	@Parameter(value = 2)
	public double standbyHours;
	
	@Parameter(value = 3)
	public double expected;
	
	public TaxCalculator calculator;
	
	@Before
	public void setup(){
		calculator = new TaxCalculator();
	}
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {BandeiraTypes.Bandeira1, 100.0, 0.0, 290.24},
                {BandeiraTypes.Bandeira2, 100.0, 0.0, 371.24},
                {BandeiraTypes.Bandeira1, 50.0, 1.0, 179.46},
                {BandeiraTypes.Bandeira2, 50.0, 1.0, 219.96},
                {BandeiraTypes.Bandeira1, 30.0, 2.0, 154.18},
                {BandeiraTypes.Bandeira2, 30.0, 2.0, 178.48},
        });
    }
    
    
	@Test
	public void paymentValueTest() {
		
		calculator.bandeiraType = flag;
		double result;
		
		try {
			result = calculator.tax(kmRun, standbyHours);
			assertEquals(result, expected, 0.005);
			
		} catch (Exception e) {
			fail("Payment Value Test Failed. Shouldnt have emitted exception");
		}
		
	}

}
