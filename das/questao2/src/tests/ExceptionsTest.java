package tests;

import org.junit.Test;

import exceptions.BandeiraException;
import exceptions.KMException;
import geral.BandeiraTaxi;

public class ExceptionsTest {
	
	@Test(expected=BandeiraException.class)
	public void testBandeiraNaoInformada() throws BandeiraException {
		BandeiraTaxi bt = new BandeiraTaxi("");
	}
	
	@Test(expected=KMException.class)
	public void testKMZerada() throws BandeiraException, KMException {
		BandeiraTaxi bt = new BandeiraTaxi("Bandeira 1");
		bt.calculaValor(0, 0);
	}

}
