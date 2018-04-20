package tests;

import org.junit.Before;
import org.junit.Test;

import Exceptions.BandeiraException;
import Exceptions.KmException;
import tarifa.Tarifa;

public class TestKMException {
	
	Tarifa tarifa;

	@Before
	public void initialize(){
		tarifa = new Tarifa();
	}
	
	@Test(expected = BandeiraException.class)
	public void TestKMException() throws KmException, BandeiraException{
		tarifa.calculoTarifa("Bandeira 1", 0, 10);
	}
}
