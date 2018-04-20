package tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import calculadoraDeTarifa.CalculadoraTarifaria;
import exceptions.BandeiraException;
import exceptions.KMException;


public class TestExceptionsTaxCalculator{

	CalculadoraTarifaria calc;
	
	@Before
	public void setup() {
		calc = new CalculadoraTarifaria();
	}
	
	@Test(expected = BandeiraException.class)
	public void testBaseDeCalculoSemRendimentos() throws BandeiraException {
		calc.calculateTax(0, 10, 10);
	}
	
	@Test(expected = KMException.class)
	public void testCalculoImpostoSemRendimentos() throws KMException {
		calc.calculateTax(1, 0, 10);
	}

}