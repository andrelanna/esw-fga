package tests;

import org.junit.Before;
import org.junit.Test;

import tarifas.Tarifa;
import tarifasException.BandeiraException;
import tarifasException.KMException;

public class ExceptionsTest {
	Tarifa tarifa;
	
	@Before
	public void setup() {
		tarifa = new Tarifa();
	}
	
	@Test(expected = KMException.class)
	public void testKMZerado() throws BandeiraException, KMException {
		tarifa.calculaTarifa(1, 0, 10);
	}
	
	@Test(expected = BandeiraException.class)
	public void testBandeiraInvalida() throws BandeiraException, KMException {
		tarifa.calculaTarifa(0, 10, 10);
	}
}
