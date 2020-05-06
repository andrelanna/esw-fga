package prova.tests;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import prova.CalculoTaxi;
import prova.exceptions.BandeiradaException;
import prova.exceptions.KMException;

@RunWith(Parameterized.class)
public class CalculoTaxiTest {
	private int bandeira;
	private float kmRodados;
	private float numHorasParadas;
	private float valorEsperado;
	private CalculoTaxi taxi;
	
	public CalculoTaxiTest(int bandeira, float kmRodados, float numHorasParadas, float valorEsperado) {
		super();
		this.bandeira = bandeira;
		this.kmRodados = kmRodados;
		this.numHorasParadas = numHorasParadas;
		this.valorEsperado = valorEsperado;
	}
	
	@Before
	public void setUp() {
		taxi = new CalculoTaxi();
	}

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 1, 100.0, 0.0 , 290.24}, 
                 { 2, 100.0, 0.0 , 371.24}, 
                 { 1, 50.0, 1.0 , 148.74}, 
                 { 2, 50.0, 1.0 , 189.24}, 
                 { 1, 30.0, 2.0 , 92.74}, 
                 { 2, 30.0, 2.0 , 117.04}  
           });
    }

    @Test
    public void testCalculoTaxiTest() {
        assertEquals(valorEsperado, taxi.calculaValor(bandeira, kmRodados, numHorasParadas), 0.0001f);
    }

	
	@Test(expected = BandeiradaException.class)
	public void testBandeiraNaoInformada() throws BandeiradaException {
		taxi.calculaValor(0, kmRodados, numHorasParadas);
	}
	
	@Test(expected = KMException.class)
	public void testKMIgualZero() throws KMException {
		taxi.calculaValor(bandeira, 0.0f, numHorasParadas);
	}
	
}
