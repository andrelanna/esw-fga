package test;

import org.junit.Test;

import calculoDeTariaTaxi.Tarifa;

public class TarifaExceptionTest {
	
	@Test(expected=BandeiraException.class)
	public void testBandeiraException() throws BandeiraException {
		Tarifa t = new Tarifa("Errou", 10, 5);
	}
	
	@Test(expected=KMException.class)
	public void testKMException() throws KMException, BandeiraException{
		Tarifa t = new Tarifa("Bandeira 1", 0, 5);
		t.calculaValorTarifa();
	}
}
