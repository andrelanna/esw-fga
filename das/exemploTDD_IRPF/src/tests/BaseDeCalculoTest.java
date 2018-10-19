package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import aplicacao.Contribuinte;
import aplicacao.Deducao;
import aplicacao.Dependente;
import aplicacao.Rendimento;

public class BaseDeCalculoTest {

	
	
	@Test
	public void test1() {
		Contribuinte c = Contribuinte.obterContribuinte("Fulano de Tal", "000.000.000-00");
		
		Rendimento r = Rendimento.obterRendimento("Salario", 10000f, false);
		Deducao ded1 = Deducao.obterDeducao("Contribuição Previdenciaria", 1000f);
		Dependente dep1 = Dependente.obterDependente("Dependente 1", "111.111.111-11");
		c.cadastrarRendimento(r);
		c.cadastrarDeducao(ded1);
		c.cadastrarDependente(dep1);
		
		assertEquals(1189.59f, c.getValorTotalDeducoes(), 0);
		assertEquals(2, c.getQtdeTotalDeducoes(), 0);
		assertEquals(8810.41f, c.getBaseCalculo(), 0);
	}
	
	
	@Test
	public void test2() {
		Contribuinte c = Contribuinte.obterContribuinte("Fulano de Tal", "000.000.000-00");
		
		Rendimento r = Rendimento.obterRendimento("Salario", 5000f, false);
		Deducao ded1 = Deducao.obterDeducao("Contribuição Previdenciaria", 700f);
		Deducao ded2 = Deducao.obterDeducao("Pensao alimenticia", 500f);
		Dependente dep1 = Dependente.obterDependente("Dependente 1", "111.111.111-11");
		Dependente dep2 = Dependente.obterDependente("Dependente 2", "222.222.222-22");
		c.cadastrarRendimento(r);
		c.cadastrarDeducao(ded1);
		c.cadastrarDeducao(ded2);
		c.cadastrarDependente(dep1);
		c.cadastrarDependente(dep2);
		
		assertEquals(1579.18f, c.getValorTotalDeducoes(), 0.01f);
		assertEquals(3, c.getQtdeTotalDeducoes(), 0);
		assertEquals(3420.82f, c.getBaseCalculo(), 0);
	}
	
	
	@Test 
	public void test3() {
		Contribuinte c = Contribuinte.obterContribuinte("Fulano de Tal", "000.000.000-00");
		
		Rendimento r = Rendimento.obterRendimento("Salario", 8000f, false);
		Deducao ded1 = Deducao.obterDeducao("Contribuição Previdenciaria", 1400f);
		Deducao ded2 = Deducao.obterDeducao("Pensao alimenticia", 500f);
		Dependente dep1 = Dependente.obterDependente("Dependente 1", "111.111.111-11");
		Dependente dep2 = Dependente.obterDependente("Dependente 2", "222.222.222-22");
		Dependente dep3 = Dependente.obterDependente("Dependente 3", "333.333.333-33");
		c.cadastrarRendimento(r);
		c.cadastrarDeducao(ded1);
		c.cadastrarDeducao(ded2);
		c.cadastrarDependente(dep1);
		c.cadastrarDependente(dep2);
		c.cadastrarDependente(dep3);
		
		assertEquals(2468.77f, c.getValorTotalDeducoes(), 0.01f);
		assertEquals(3, c.getQtdeTotalDeducoes(), 0);
		assertEquals(5531.23f, c.getBaseCalculo(), 0.01f);
	}

}
