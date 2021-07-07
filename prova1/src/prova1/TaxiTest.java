package prova1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


class TaxiTest {

	public double[] arrayKmRodados = {100.00, 100.00, 50.00, 50.00, 30.00, 30.00};
	public int[] arrayHorasParadas = {0,0,1,1,2,2,};
	public Integer[] arrayBandeira = {1,2,1,2,1,2};
	public double[] resultados = {290.24, 371.24, 179.46, 219.96, 158.18, 178.48};
	
	@Test
	void testA() {
		Taxi taxi = new Taxi();
		int i=0;
		int resultado=0;
		for(i=0; i<6; i++) {
			resultado = 0;
			resultado = (int) taxi.calcularCorrida(arrayKmRodados[i], arrayHorasParadas[i], arrayBandeira[i]);
			assertEquals(resultado, resultados[i], resultados[i]);
		}
	}
	
	@Test()
	void testB() {
		Taxi taxi2 = new Taxi();
		try {
			taxi2.calcularCorrida(100.00,  2, -1);
			fail("nao deu certo esse teste"); // importante, não pode esquecer!
		} catch (RuntimeException e) {
			assertEquals("Bandeira nao foi informada", e.getMessage());
		}
	}
	
	@Test()
	void testC() {
		Taxi taxi3 = new Taxi();
		try {
			taxi3.calcularCorrida(0.0,  2, 1);
			fail("nao deu certo esse teste"); // importante, não pode esquecer!
		} catch (RuntimeException e) {
			assertEquals("Numero de KMs nao pode ser zero", e.getMessage());
		}
	}

}
