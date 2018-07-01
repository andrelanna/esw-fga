package testes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import calculaTarifaTaxi.CalculaTarifaTaxi;
import excecoes.BandeiraException;
import excecoes.KMException;

@RunWith(Parameterized.class)
public class TesteCalculaTarifa {
	
	static String bandeira;
	static float kmRodados, numHorasParadas;
	static float resultadoEsperado;
	
	public TesteCalculaTarifa(String bandeira, float kmRodados, float numHorasParadas, float resultadoEsperado) {
		this.bandeira = bandeira;
		this.kmRodados = kmRodados;
		this.numHorasParadas = numHorasParadas;
		this.resultadoEsperado = resultadoEsperado;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"Bandeira 1", 100f, 0f, 290.24f},
			{"Bandeira 2", 100f, 0f, 371.24f},
			{"Bandeira 1", 50f, 1f, 179.46f},
			{"Bandeira 2", 50f, 1f, 219.96f},
			{"Bandeira 1", 30f, 2f, 154.18f},
			{"Bandeira 2", 30f, 2f, 178.48f}
		});
	}
	
	@Test
	public void testeCalculaTarifa() throws BandeiraException, KMException {
		CalculaTarifaTaxi calculaTarifaTaxi = new CalculaTarifaTaxi();
		float resultado = calculaTarifaTaxi.calculaTarifa(bandeira, kmRodados, numHorasParadas);

		assertEquals(resultadoEsperado, resultado, 0);
	}
}
