package calculoTarifa.tests;

import org.junit.BeforeClass;
import org.junit.Test;

import calculoDeTarifa.CalculoTarifa;
import calculoTarifa.exception.BandeiraException;
import calculoTarifa.exception.KMException;

public class CalculaTarifaExceptionTests {


		static CalculoTarifa calculoTarifa;
		
		@BeforeClass
		public static void setup() {
			calculoTarifa = new CalculoTarifa();
		}
		
		
		@Test(expected = BandeiraException.class)
		public void TestExcecaoBandeira() throws BandeiraException, KMException {
			calculoTarifa.calculaValorTarifa("", 1, 0);
		}
		
		@Test(expected = KMException.class)
		public void TestExcecaoKM() throws BandeiraException,KMException {
			calculoTarifa.calculaValorTarifa("Bandeira 1", 0, 0);
		}
}