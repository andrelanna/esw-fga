package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import tarifa.Tarifa;

@RunWith(Parameterized.class)
public class TarifaTests {
	
	Tarifa tarifa;
	double valorEsperado;
	String bandeira;
	int km;
	int hrsParadas;
	
	public TarifaTests(String bandeira, int km, int hrsParadas){
		this.bandeira = bandeira;
		this.km = km;
		this.hrsParadas = hrsParadas;
	}
	
	@Before
	public void initialize(){
		tarifa = new Tarifa();
	}
	
	@Parameterized.Parameters
	public static Collection values(){
		return Arrays.asList(new Object[][] { {"Bandeira 1", 100, 0}, {"Bandeira 2", 100, 0}, {"Bandeira 1", 50, 1}, {"Bandeira 2", 50, 1}, {"Bandeira 1", 30, 2}, {"Bandeira 2", 30, 2} });
	}
	
	@Test
	public void TesteTarifa(){
		assertEquals(valorEsperado, tarifa.calculoTarifa(bandeira, km, hrsParadas));
	}
}
