package test;

import org.junit.Test;

import exception.BandeiraException;
import exception.KMException;
import source.Corrida;

public class TestesDeExcessao {	
	@Test(expected = BandeiraException.class)
	public void testBandeiraException() throws BandeiraException, KMException{
		Corrida corrida = new Corrida(7, 100, 0);
		corrida.calculaValor();
	}
	
	@Test(expected = KMException.class)
	public void testKMException() throws BandeiraException, KMException{
		Corrida corrida = new Corrida(1, 0, 0);
		corrida.calculaValor();
	}
	
	@Test(expected = BandeiraException.class)
	public void testBandeiraExceptionWhenKMNotExist() throws BandeiraException, KMException{
		Corrida corrida = new Corrida(0, 0, 0);
		corrida.calculaValor();
	}

}
