package testes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import excecoes.BandeiraException;
import excecoes.KMException;
import models.Corrida;

@RunWith(Parameterized.class)
public class TesteParametrizado {
	String bandeira;
	double kmRodado;
	double numHorasParadas;
	double valorCorrida;
	
	public TesteParametrizado(String bandeira, double kmRodado, double numHorasParadas, double valorCorrida) {
		this.bandeira = bandeira;
		this.kmRodado = kmRodado;
		this.numHorasParadas = numHorasParadas;
		this.valorCorrida = valorCorrida;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{"Bandeira 1", 100, 0 , 290.24},
			{"Bandeira 2", 100, 0, 371.24},
			{"Bandeira 1", 50, 1, 179.46},
			{"Bandeira 2", 50, 1, 219.96},
			{"Bandeira 1", 30, 2, 154.18},
			{"Bandeira 2", 30, 2, 178.48}
		});
		
	}
	
	@Test
	public void testeTarifaParametrizado() throws BandeiraException, KMException {
		Corrida corrida = new Corrida();
		assertEquals(this.valorCorrida, corrida.calculaTarifa(this.bandeira, this.kmRodado, this.numHorasParadas), 0.00000000001);
	}
	
	
}
