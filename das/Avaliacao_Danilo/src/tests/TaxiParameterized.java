package tests;


import static org.junit.Assert.assertEquals;

import tarifas.TarifaTaxi;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TaxiParameterized {

	@Parameters(name="{index}: taxi({0}, {1}, {2})= {3}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{1, 100, 0, 290.24}, {2, 100, 0, 371.24}, {1, 50, 1, 179.46}, {2, 50, 1, 219.96}, {1, 30, 2, 154.18}, {2, 30, 2, 178.48}
		});
	}
	
	private int bandeira;
	private double kmRodados;
	private double numHorasParadas;
	private double esperado;
	private TarifaTaxi ttaxi;
	
	public TaxiParameterized(int bandeira,
			double kmRodados,
			double numHorasParadas,
			double esperado
			) {
		this.bandeira = bandeira;
		this.kmRodados = kmRodados;
		this.numHorasParadas = numHorasParadas;
		this.esperado = esperado;
		this.ttaxi = new TarifaTaxi(bandeira, kmRodados, numHorasParadas);
	}
	
	@Test
	public void test() {
		assertEquals(esperado, ttaxi.getValorCorrida(), 0.001f);
	}

}

