package tests;

import org.junit.Test;

import exceptions.BandeiraException;
import exceptions.KMException;
import prova.TarifaTaxi;

public class TarifaExceptionTest {
	TarifaTaxi tt = new TarifaTaxi();
	
	@Test(expected = BandeiraException.class)
	public void testBandeira() throws BandeiraException, KMException {
		tt.calculaTarifa("", 20,0);
	}
	@Test(expected = KMException.class)
	public void testKM() throws BandeiraException, KMException {
		tt.calculaTarifa("Bandeira 1", 0, 2);
	}
}
