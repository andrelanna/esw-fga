package testes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import excecao.BandeiraException;
import excecao.KMException;
import taxi.Taxi;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)
public class TesteTatifaTaxi {

	private Taxi taxi;
	private double valorTipoBandeira;
	private double kmRodados;
	private double numHorasParadas;
	private double resultado;
	
	public TesteTatifaTaxi(double valorTipoBandeira, double kmRodados, double numHorasParadas, double resultado) {
		this.valorTipoBandeira = valorTipoBandeira;
		this.kmRodados = kmRodados;
		this.numHorasParadas = numHorasParadas;
		this.resultado = resultado;
	}
	
	@Before
	public void setup() {
		taxi = new Taxi();
		taxi.setValorHoraParada(Taxi.VALOR_HORA_PARADA);
	}

	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{2.85, 100.0, 0.0, 290.24},
			{3.66, 100.0, 0.0, 371.24},
			{2.85, 50.0, 1.0, 179.46},
			{3.66, 50.0, 1.0, 219.96},
			{2.85, 30.0, 2.0, 154.18},
			{3.66, 30.0, 2.0, 178.48}
		});
	}
	
	@Test
	public void teste0Tarifas() throws BandeiraException, KMException {
		taxi.setValorTipoBandeira(this.valorTipoBandeira);
		double retorno = taxi.calculaTarifaTaxi(this.kmRodados, this.numHorasParadas);
		System.out.println(retorno);
		assertEquals(this.resultado, retorno, 0.0001);
	}
	
}
