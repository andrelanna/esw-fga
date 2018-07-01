package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.BeforeClass;

import exceptions.*;
import tarifas.TarifaTaxi;

public class TaxiExceptionTest {

	static TarifaTaxi taxi;
	
	@Test
	public void bandeiraNula() throws BandeiraException {
		taxi = new TarifaTaxi(0, 0, 0);
		assertNotNull(taxi);
	}
	
	@Test
	public void KmException() throws KMException {
		taxi = new TarifaTaxi(0, 0, 0);
		assertNotNull(taxi);
	}
}
