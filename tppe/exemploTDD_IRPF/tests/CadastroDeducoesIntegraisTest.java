package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import aplicacao.Contribuinte;
import aplicacao.Deducao;

@RunWith(Parameterized.class)
public class CadastroDeducoesIntegraisTest {

	//Atributos do objeto de teste
	String nomeContribuinte, 
	       cpfContribuinte;
	TstParametrosDeducao[] deducoes; 
	float valorTotalDeducoes;
	private int qtdeDeducoes;
	
	public CadastroDeducoesIntegraisTest(
			String nomeContribuinte, 
			String cpfContribuinte, 
			TstParametrosDeducao[] deducoes, 
			float valorTotalDeducoes, 
			int qtdeDeducoes) {
		this.nomeContribuinte = nomeContribuinte;
		this.cpfContribuinte = cpfContribuinte;
		this.deducoes = deducoes;
		this.valorTotalDeducoes = valorTotalDeducoes;
		this.qtdeDeducoes = qtdeDeducoes;
	}

	
	@Parameters
	public static Collection<Object[]> getParameters() {
		//Parametros 1 - Pensao Alimenticia - R$1000,00
		TstParametrosDeducao d1 = new TstParametrosDeducao(
				"Pensao alimenticia", 
				1000f);
		TstParametrosDeducao[] deducoes = new TstParametrosDeducao[] {d1};
		Object[] par1 = new Object[] {
				"Fulano", 
				"111.222.333-44", 
				deducoes,
				1000f, 
				1
		};
		
		//Parametros 2 - Contribuicao Previdenciaria - R$1500,00
		TstParametrosDeducao d2 = new TstParametrosDeducao(
				"Contribuicao Previdenciaria", 
				1500f);
		TstParametrosDeducao[] deducoes2 = new TstParametrosDeducao[] {d2};
		Object[] par2 = new Object[] {
				"Fulano", 
				"111.222.333-44", 
				deducoes2,
				1500f, 
				1
		};
		
		
		//Parametros 2 - Cont Prev. - R$1500,00
		//Pensao Alimenticia - 1000
		//Total : 2500
		TstParametrosDeducao d3 = new TstParametrosDeducao(
				"Contribuicao Previdenciaria", 
				1500f);
		TstParametrosDeducao d4 = new TstParametrosDeducao(
				"Pensao Alimenticia", 
				1000f);
		TstParametrosDeducao[] deducoes3 = new TstParametrosDeducao[] {d3, d4};
		Object[] par3 = new Object[] {
				"Fulano", 
				"111.222.333-44", 
				deducoes3,
				2500f, 
				2
		};
		
		return Arrays.asList(new Object[][] {
			par1, 
			par2, 
			par3
		});
		
	}
	
	@Test
	public void testCadastroPensaoAlimenticia() {
		Contribuinte c = Contribuinte.obterContribuinte(nomeContribuinte, cpfContribuinte);
		for (TstParametrosDeducao par : deducoes) {
			Deducao d = Deducao.obterDeducao(par.descricao, par.valor);
			boolean cadastro = c.cadastrarDeducao(d);
			assertTrue(cadastro);
		}
		assertEquals(c.getQtdeTotalDeducoes(), qtdeDeducoes);
		assertEquals(c.getValorTotalDeducoes(), valorTotalDeducoes, 0);
	}
}
