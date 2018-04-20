package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import calculoDeTariaTaxi.Tarifa;

@RunWith(Parameterized.class)
public class TarifaTest {
	
	Tarifa tarifa;
	String bandeira;
	float kmRodados;
	int horaParada;
	float expected;
	
	public TarifaTest(Tarifa t, float expected) {
		this.tarifa = t;
		this.expected = expected;
	}
	
	@Parameters
	public static Collection<Object[]> data() throws BandeiraException{
		return Arrays.asList(new Object[][] {
				{new Tarifa("Bandeira 1", 100f, 0), 321.96f}, 
				{new Tarifa("Bandeira 2", 100f, 0), 402.96f}, 
				{new Tarifa("Bandeira 1", 50f, 1), 180.46f},
				{new Tarifa("Bandeira 2", 50f, 1), 220.96f},
				{new Tarifa("Bandeira 1", 30f, 2), 124.46f},
				{new Tarifa("Bandeira 2", 30f, 2), 148.76f}
		});
	}
	
	@Test
	public void testCalculaTarifa() throws KMException{
		float valor = tarifa.calculaValorTarifa();
		assertEquals(expected, valor, 0.0001);
	}
	
}
