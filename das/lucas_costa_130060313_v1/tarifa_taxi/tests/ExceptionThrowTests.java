package tests;


import org.junit.Before;
import org.junit.Test;
import exceptions.*;
import src.*;

public class ExceptionThrowTests {

	private TaxCalculator taxCalc;
	
	@Before
	public void setup(){
		taxCalc = new TaxCalculator();
	}
	
	@Test(expected = KMException.class)
	public void EmptyKmTest() throws Exception{
		taxCalc.bandeiraType = BandeiraTypes.Bandeira1;
		taxCalc.tax(0, 10);
	}
	
	@Test(expected = BandeiraException.class)
	public void EmptyFlagTest() throws Exception{
		taxCalc.tax(10, 10);
	}

}
