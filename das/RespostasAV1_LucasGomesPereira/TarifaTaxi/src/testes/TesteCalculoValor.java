package testes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import calculo.*;

//Teste parametrizado por construtor
@RunWith(Parameterized.class)
public class TesteCalculoValor {
	private int bandeira;
	private double kmRodados;
	private double numHorasParadas;
	private double resultado;
	
	private CalculoTarifa calculoTarifa;
	
	@Before
	public void setUp() throws Exception {
		calculoTarifa = new CalculoTarifa();
	}
	
	//Construtor
	public TesteCalculoValor(int bandeira, double kmRodados, double numHorasParadas, double resultado) {
		this.bandeira = bandeira;
		this.kmRodados = kmRodados;
		this.numHorasParadas = numHorasParadas;
		this.resultado = resultado;
	}
	
	//Definição das tuplas
	@Parameters
	public static Collection<Object[]> testData(){
		Object[][] data = new Object[][] {
			{1,100.0,0.0,290.24},
			{2,100.0,0.0,371.24},
			{1,50.0,1.0,179.46},
			{2,50.0,1.0,219.96},
			{1,30.0,2.0,154.18},
			{2,30.0,2.0,178.48}
		};
		
		return Arrays.asList(data);
	}
	
	//Testes
	@Test
	public void test() throws BandeiraExeption, KMExeption {
		assertEquals(calculoTarifa.calcula(bandeira, kmRodados, numHorasParadas), resultado, 0.1);
		System.out.println(resultado);
	}

}
