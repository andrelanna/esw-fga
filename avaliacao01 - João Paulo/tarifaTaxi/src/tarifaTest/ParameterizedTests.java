package tarifaTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import tarifaCategoriaTestes.CategoriaExcecao;
import tarifaExcecao.BandeiraException;
import tarifaExcecao.KMException;
import tarifaTaxi.tarifaTaxi;

@RunWith(Parameterized.class)
public class ParameterizedTests {
	private int bandeira = 0;
	private double kmRodados = 0;
	private double horasParadas = 0;
	private double resultadoTarifa;
	
	tarifaTaxi tarifa = new tarifaTaxi();
	
	public ParameterizedTests(
		int bandeira,
		double kmRodados,
		double horasParadas,
		double resultadoTarifa
		){
		super();
		this.bandeira = bandeira;
		this.kmRodados = kmRodados;
		this.horasParadas = horasParadas;
		this.resultadoTarifa = resultadoTarifa;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{
				1,100,0, //entradas
				290.24 //resultado
				
			},{
				2,100,0,
				371.24
			},{
				1,50,1,
				179.46
			},{
				2,50,1,
				219.96
			},{
				1,30,2,
				154.18
			},{
				2,30,3,
				210.2
			}
		});
	}
	
	@Test
	public void tarifaTeste() throws BandeiraException, KMException{
		double retorno = tarifa.calculaTarifa(this.bandeira, this.kmRodados, this.horasParadas);
		assertEquals(this.resultadoTarifa, retorno, 0.1);
	}

	@Category(CategoriaExcecao.class)
	@Test(expected = BandeiraException.class)
	public void tarifaExceptionTeste() throws BandeiraException, KMException{
		tarifa.calculaTarifa(0, 100, 0);
		
	}
	
	@Category(CategoriaExcecao.class)
	@Test(expected = KMException.class)
	public void tarifaExceptionTeste2() throws KMException, BandeiraException{
		tarifa.calculaTarifa(1, 0, 0);
	}
	
}
