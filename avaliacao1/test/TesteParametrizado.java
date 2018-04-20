package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exception.BandeiraException;
import exception.KMException;
import source.Corrida;

@RunWith(Parameterized.class)
public class TesteParametrizado {
	
	
	private Corrida corrida;
	private int bandeira;
	private double kmRodados;
	private double numHorasParadas;
	private double resultado;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        	{1, 100, 0, 290.24},
        	{2, 100, 0, 371.24}, 
        	{1, 50, 1, 179.46},
        	{2, 50, 1, 219.96},
        	{1, 30, 2, 154.18},
        	{2, 30, 2, 178.48000000000002}
         });
    }
     
	
	public TesteParametrizado(int bandeira, double kmRodados, double numHorasParadas, double resultado) {
		super();
		this.bandeira = bandeira;
		this.kmRodados = kmRodados;
		this.numHorasParadas = numHorasParadas;
		this.resultado = resultado;
	}
	
	@Before
	public void setUp() {
		this.corrida = new Corrida(this.bandeira, this.kmRodados, this.numHorasParadas);
	}
	
	@Test
	public void testValorCorrida() throws BandeiraException, KMException{
		double valor = this.corrida.calculaValor();
		assertEquals(this.resultado, valor, 0.01);
	}

}
