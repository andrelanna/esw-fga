package exemploTDD_IRPF.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import exemploTDD_IRPF.aplicacao.Contribuinte;
import exemploTDD_IRPF.aplicacao.Rendimento;

public class CadastroRendimentosTeste {

	@Test
	public void testCadastroUmRendimento() {
		Contribuinte c = Contribuinte.obterContribuinte("Fulano", "111.222.333-44");
		Rendimento  r = Rendimento.obterRendimento("Salario", 4000.00f, false);
		boolean resposta = c.cadastrarRendimento(r); 
		
		assertTrue(resposta);
		assertEquals(1, c.getQtdeTotalRendimentos());
		assertEquals(4000.00f, c.getValorTotalRendimentos(), 0f);
	}
	
	@Test
	public void testCadastroOutroRendimento() {
		Contribuinte c = Contribuinte.obterContribuinte("Fulano", "111.222.333-44");
		Rendimento  r = Rendimento.obterRendimento("Aluguel", 2000.00f, false);
		boolean resposta = c.cadastrarRendimento(r); 
		
		assertTrue(resposta);
		assertEquals(1, c.getQtdeTotalRendimentos());
		assertEquals(2000.00f, c.getValorTotalRendimentos(), 0f);
	}
}
