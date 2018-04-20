package classes;

import org.junit.Before;
import org.junit.Test;

public class ExceptionsTest {
	 TarifaTaxi tarifaTaxi;
	 
	 @Before
	 public void setup() {
	  tarifaTaxi = new TarifaTaxi();
	 }
	 
	 @Test(expected = BandeirasException.class)
	 public void testSemBandeira() throws BandeirasException, KMExceptions  {
		 TarifaTaxi.calculaTarifa(0, 5, 100);
	 }
	 
	 @Test(expected = KMExceptions.class)
	 public void testKMZero() throws BandeirasException, KMExceptions {
		 TarifaTaxi.calculaTarifa(1, 0, 100);
	 }
}