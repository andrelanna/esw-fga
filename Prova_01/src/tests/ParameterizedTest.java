package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import tarifas.Tarifa;
import tarifasException.BandeiraException;
import tarifasException.KMException;

@RunWith(Parameterized.class)
public class ParameterizedTest {
	Tarifa tarifa;
	@Before
	public  void setup ()  {
		tarifa = new Tarifa(5.24f, 31.72f);
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{1, 100, 0, 290.24f}, {2, 100, 0, 371.24f}, {1, 50, 1, 179.46f}, {2, 50, 1, 219.96f} , {1, 30, 2, 154.18f}, {2, 30, 2, 178.48f} 
		});
	}
	
	private int bandeira;
	private int kmsRodados;
	private int horasParadas;
	private float resultado;
	public ParameterizedTest(int bandeira, int kmsRodados, int horasParadas, float resultado) {
		super();
		this.bandeira = bandeira;
		this.kmsRodados = kmsRodados;
		this.horasParadas = horasParadas;
		this.resultado = resultado;
	}
	
	@Test
	public void testCalculaTarifa () throws BandeiraException, KMException {
		assertEquals(resultado, tarifa.calculaTarifa(bandeira, kmsRodados, horasParadas), 1f);
	}
	
}
