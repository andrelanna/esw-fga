package tests;

import org.junit.Before;
import org.junit.Test;

import Exceptions.BandeiraException;
import Exceptions.KmException;
import tarifa.Tarifa;

public class TestBandeiraException {
	Tarifa tarifa;
	double valorEsperado;
	String bandeira;
	int km;
	int hrsParadas;

	@Before
	public void initialize(){
		tarifa = new Tarifa();
	}
	
	@Test(expected = BandeiraException.class)
	public void TestBException() throws BandeiraException, KmException{
		tarifa.calculoTarifa(null, 10, 10);
	}
}
