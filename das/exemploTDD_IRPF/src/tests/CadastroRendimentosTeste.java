package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import aplicacao.Contribuinte;
import aplicacao.Rendimento;

@RunWith(Parameterized.class)
public class CadastroRendimentosTeste {

	
	//Definição dos atributos do objeto de teste, conforme unidade sob teste.
	String nomeContribuinte, 
	       cpfContribuinte;
	ParametrosRendimentosTest[] parametrosRendimentos; 
	float totalRendimentos;
	
	/**
	 * Construtor alternativo do objeto de teste
	 * @param nomeContribuinte 
	 * @param cpfContribuinte
	 * @param parametrosRendimentos
	 * @param totalRendimentos
	 */
	public CadastroRendimentosTeste(
			String nomeContribuinte, 
			String cpfContribuinte, 
			ParametrosRendimentosTest[] parametrosRendimentos, 
			float totalRendimentos) {
		this.nomeContribuinte = nomeContribuinte;
		this.cpfContribuinte = cpfContribuinte;
		this.parametrosRendimentos = parametrosRendimentos;
		this.totalRendimentos = totalRendimentos;
	}
	
	
	
	
	/**
	 * Metodo que retorna o conjunto de parametros que serao utilizados pelo teste
	 * @return
	 */
	@Parameters
	public static Collection<Object[]> getParameters() {
		// PARAMETROS 1 - Cadastro de um rendimento apenas
		ParametrosRendimentosTest[] rendimentos1 = new ParametrosRendimentosTest[] {
				new ParametrosRendimentosTest("Salario", 4000.00f, false)
				};
		Object[] parametros1 = new Object[]{"Fulano", "111.222.333-44", rendimentos1, 4000.00f};

		//PARAMETROS 2 - Cadastro de um outro rendimento apenas
		ParametrosRendimentosTest[] rendimentos2 = new ParametrosRendimentosTest[] {
				new ParametrosRendimentosTest("Aluguel", 2000.00f, false)
		};
		Object[] parametros2 = new Object[] {"Fulano", "111.222.333-44", rendimentos2, 2000.00f};
		
		//PARAMETROS 3 - Cadastro de dois rendimentos para um mesmo contribuinte
		ParametrosRendimentosTest[] rendimentos3 = new ParametrosRendimentosTest[] {
				new ParametrosRendimentosTest("Salario", 4000.00f, false),
				new ParametrosRendimentosTest("Aluguel", 2000.00f, false)
		};
		Object[] parametros3 = new Object[] {"Fulano", "111.222.333-44", rendimentos3, 6000.00f};
		
		return Arrays.asList(new Object[][] {
			parametros1, 
			parametros2, 
			parametros3
		});
	}
	
	
	
	
	@Test
	public void testeCadastroDeRendimentos() {
		Contribuinte c = Contribuinte.obterContribuinte(nomeContribuinte, cpfContribuinte);
		for (ParametrosRendimentosTest p : parametrosRendimentos) {
			Rendimento r = Rendimento.obterRendimento(p.descricao, p.valor, p.isentoIR);
			boolean resposta = c.cadastrarRendimento(r);
			assertTrue(resposta);
		}
		assertEquals(totalRendimentos, c.getValorTotalRendimentos(), 0f);
	}
}