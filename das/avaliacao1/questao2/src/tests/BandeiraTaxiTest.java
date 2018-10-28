package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exceptions.BandeiraException;
import exceptions.KMException;
import geral.BandeiraTaxi;

@RunWith(Parameterized.class)
public class BandeiraTaxiTest {
	private String bandeiraName;
	private int km;
	private int horas;
	private double expected;
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{"Bandeira 1", 100, 0, 290.24}, {"Bandeira 2", 100, 0, 371.24},
			{"Bandeira 1", 50, 1, 179.46}, {"Bandeira 2", 50, 1, 219.96},
			{"Bandeira 1", 30, 2, 154.18}, {"Bandeira 2", 30, 2, 178.48}
		}
		);
	}
	
	public BandeiraTaxiTest(String name, int kmp, int horasp, double expectedp) {
		bandeiraName = name;
		km = kmp;
		horas = horasp;
		expected = expectedp;
	}
	
	@Test
	public void testBandeiraResults() throws KMException, BandeiraException {
		assertEquals(expected, new BandeiraTaxi(bandeiraName).calculaValor(km, horas), 0.0001);
	}

}
