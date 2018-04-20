package test;

import org.junit.Test;
import org.junit.runner.RunWith;

import exceptions.BandeiraException;
import exceptions.KMException;
import tarifa.Tarifa;

public class TarifaTestException {

	@Test(expected = KMException.class)
	public void testKmException() throws BandeiraException, KMException {
		Tarifa tarifa = new Tarifa(Tarifa.BANDEIRADA, 0.0, Tarifa.BANDEIRA_1, 0,
				Tarifa.VALOR_HORA_PARADA);
		tarifa.calculaValor();
	}
	
	@Test(expected = BandeiraException.class)
	public void testBandeiraExpection() throws BandeiraException, KMException {
		Tarifa tarifa = new Tarifa(Tarifa.BANDEIRADA, 100.0, 0.0, 0,
				Tarifa.VALOR_HORA_PARADA);
		tarifa.calculaValor();
	}	
}
