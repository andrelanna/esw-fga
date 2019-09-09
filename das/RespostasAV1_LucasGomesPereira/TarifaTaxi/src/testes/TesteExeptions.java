package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import calculo.BandeiraExeption;
import calculo.CalculoTarifa;
import calculo.KMExeption;

public class TesteExeptions {
	
	private CalculoTarifa calculoTarifa;
	
	@Before
	public void setUp() throws Exception {
		calculoTarifa = new CalculoTarifa();
	}

	@Test(expected = BandeiraExeption.class)
	public void testBandeiraExeption() throws BandeiraExeption, KMExeption {
		//10 é uma bandeira fora do possível, então pode ser intendida como não informada
		calculoTarifa.calcula(10, 100, 2);
	}
	
	@Test(expected = KMExeption.class)
	public void testKMExeption() throws BandeiraExeption, KMExeption {
		calculoTarifa.calcula(2, 0, 2);
	}

}
