package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import av1_tarifabandeira.Tarifa;
import av1_tarifabandeira.TarifaBandeira;

public class TarifaBandeiraTest {
	
	static Tarifa tarifa; 
	static TarifaBandeira tarifaband;
	
	@BeforeClass
	public static void setup() {
		//tarifa = new Tarifa();
	}
	
	@Test 
	public void testCalculoTarifa() {
		Tarifa tb = new Tarifa(0, 0, 0);
		
		float resposta = Tarifa.calcularBaseDeCalculo(tarifa.getDescricao(), tarifa.getKmRodados(), tarifa.getNumHorasParadas());
		assertTrue(resposta > 0);

	}

}
