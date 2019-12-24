package test;

import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import tarifaTaxi.TarifaTaxiService;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestTarifaTaxi {

	private double bandeira;
	private Integer km;
	private Integer hora;
	private double tarifa;

	public TestTarifaTaxi(double bandeira, Integer km, Integer hora, double tarifa) {
		this.bandeira = bandeira;
		this.km = km;
		this.hora = hora;
		this.tarifa = tarifa;
	    }
	
	 @Test
	    public void testeCalculoTarifaTaxi() throws Exception {
		 TarifaTaxiService tarifa = new TarifaTaxiService();

	        tarifa.addBandeira(bandeira);
	        tarifa.addKm(km);
	        tarifa.addHora(hora);

	        Double calculoTarifa = tarifa.calculoTarifa(bandeira, km, hora);

	        assertEquals(this.tarifa, calculoTarifa, 0.0);
	    }


	@Parameterized.Parameters(name = "{index}: {0}{1}{2}")
	public static Collection<Object[]> data() {
	return Arrays.asList(new Object[][]{
	     // bandeira, km, hora, tarifa
	     {2.85, 100, 0, 290.24},
	     {3.66, 100, 0, 371.24},
	     {2.85, 50, 1, 179.46},
	     {3.66, 50, 1, 219.96},
	     {2.85, 30, 2, 154.18},
	     {3.66, 30, 2, 178.48},
	     });
	   }
	}
