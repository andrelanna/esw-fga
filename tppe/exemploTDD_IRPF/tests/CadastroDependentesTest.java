package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import aplicacao.Contribuinte;
import aplicacao.Dependente;


@RunWith(Parameterized.class)
public class CadastroDependentesTest {

	private Dependente[] dependentes;
	private int qtdeEsperadaDependentes;
	private int qtdeEsperadaDeducoes;
	private float valorEsperadoDeducoes;

	public CadastroDependentesTest(Object[] dependentes, 
			int qtdeEsperadaDependentes,
			int qtdeEsperadaDeducoes,
			float valorEsperadoDeducoes) {
		this.dependentes = (Dependente[])dependentes;
		this.qtdeEsperadaDependentes = qtdeEsperadaDependentes;
		this.qtdeEsperadaDeducoes = qtdeEsperadaDeducoes;
		this.valorEsperadoDeducoes = valorEsperadoDeducoes;
	}
	
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		//formato tupla
		//{[Dependente], qtdeEsperadaDependentes, qtdeEsperadaDeducoes, valorEsperadoDeducoes}
		Dependente d1 = Dependente.obterDependente("Dependente 1", "111.111.111-11");
		Dependente deps1[] = new Dependente[] {d1};
		Object[] par1 = new Object[] {deps1, 1, 1, 189.59f};
		
		Dependente d2 = Dependente.obterDependente("Dependente 2", "222.222.222-22");
		Dependente deps2[] = new Dependente[] {d1, d2};
		Object[] par2 = new Object[] {deps2, 2, 1, 379.18f};
		
		Dependente d3 = Dependente.obterDependente("Dependente 3", "333.333.333-33");
		Dependente deps3[] = new Dependente[] {d1, d2, d3};
		Object[] par3 = new Object[] {deps3, 3, 1, 568.77f};
		
		Object[][] parametros = new Object[][] {par1,
			                                    par2,
			                                    par3};
			                                    
        return Arrays.asList(parametros);
		}
	
	
    @Test
    public void testCadastroDependentes() {
    	Contribuinte c = Contribuinte.obterContribuinte("Fulano de tal", "000.000.000-00");
    	for (Dependente d : dependentes) {
    		Dependente dep = Dependente.obterDependente(d.getNome(), d.getCPF());
    		boolean resposta = c.cadastrarDependente(dep);
    		assertTrue(resposta);
    	}
    	assertEquals(qtdeEsperadaDependentes, c.getNumTotalDependentes());
    	assertEquals(qtdeEsperadaDeducoes, c.getQtdeTotalDeducoes());
    	assertEquals(valorEsperadoDeducoes, c.getValorTotalDeducoes(), 0);
    }
}
