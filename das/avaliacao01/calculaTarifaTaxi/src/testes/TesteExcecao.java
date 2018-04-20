package testes;

import org.junit.Test;

import calculaTarifaTaxi.CalculaTarifaTaxi;
import excecoes.BandeiraException;
import excecoes.KMException;

public class TesteExcecao {
	@Test(expected=BandeiraException.class)
	public void testeBandeiraException() throws BandeiraException, KMException {
		CalculaTarifaTaxi calculaTarifaTaxi = new CalculaTarifaTaxi();
		
		calculaTarifaTaxi.calculaTarifa("", 100f, 0f);
	}
	
	@Test(expected=KMException.class)
	public void testeKMException() throws BandeiraException, KMException {
		CalculaTarifaTaxi calculaTarifaTaxi = new CalculaTarifaTaxi();
		
		calculaTarifaTaxi.calculaTarifa("Bandeira 1", 0f, 0f);
	}
}
