package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import Exceptions.BandeiraException;
import Exceptions.KmException;
import tarifa.Tarifa;

@RunWith(Parameterized.class)
public class TarifaTests {
	
	Tarifa tarifa;
	double valorEsperado;
	String bandeira;
	int km;
	int hrsParadas;
	
	public TarifaTests(double valorEsperado, String bandeira, int km, int hrsParadas){
		this.valorEsperado = valorEsperado;
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
		return Arrays.asList(new Object[][] { {290.24, "Bandeira 1", 100, 0}, {371.24, "Bandeira 2", 100, 0}, {179.46, "Bandeira 1", 50, 1}, {219.96, "Bandeira 2", 50, 1}, {154.18, "Bandeira 1", 30, 2}, {178.48, "Bandeira 2", 30, 2} });
	}
	
	@Test
	public void TesteTarifa() throws BandeiraException, KmException{
		assertEquals(valorEsperado, tarifa.calculoTarifa(bandeira, km, hrsParadas), 0.01);
	}
}
