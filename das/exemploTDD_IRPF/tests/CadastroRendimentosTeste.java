package exemploTDD_IRPF.tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class CadastroRendimentosTeste {

	@Test
	public void testCadastroUmRendimento() {
		Contribuinte c = Contribuinte.obterContribuinte("Fulano", "111.222.333-44");
		Rendimento  r = Rendimento.obterRendimento("Salario", 4000.00f, false);
		
		assertEquals(1, c.getQtdeTotalRendimentos());
		assertEquals(4000.00f, c.getValorTotalRendimentos());
	}
}
