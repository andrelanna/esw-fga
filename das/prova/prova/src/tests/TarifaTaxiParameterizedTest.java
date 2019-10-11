package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import exceptions.BandeiraException;
import exceptions.KMException;
import prova.TarifaTaxi;

@RunWith(Parameterized.class)
public class TarifaTaxiParameterizedTest {
	TarifaTaxi tt = new TarifaTaxi();
	public String bandeira;
	public int km;
	public int hora;
	public float expected;
	
	public TarifaTaxiParameterizedTest(String bandeira, int km, int hora, float expected) {
		this.bandeira = bandeira;
		this.km = km;
		this.hora = hora;
		this.expected = expected;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> corridaData(){
		return Arrays.asList(new Object[][] {
			{"Bandeira 1",100,0,290.25f},
			{"Bandeira 2",100,0,371.25f},
			{"Bandeira 1",50,1,179.47f},
			{"Bandeira 2",50,1,219.97f},
			{"Bandeira 1",30,2,154.19f},
			{"Bandeira 2",30,2,178.49f},
		});
	}
	

	@Test
	public void testCorrida() throws BandeiraException, KMException {
		assertEquals(tt.calculaTarifa(bandeira, km, hora),expected,0f);
	}
	
}
