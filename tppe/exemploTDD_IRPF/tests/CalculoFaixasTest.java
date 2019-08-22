package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import aplicacao.Contribuinte;
import aplicacao.Deducao;
import aplicacao.Dependente;
import aplicacao.Imposto;
import aplicacao.Rendimento;

public class CalculoFaixasTest {

	@Test
	public void test1() {
Contribuinte c = Contribuinte.obterContribuinte("Fulano de Tal", "000.000.000-00");
		
		Rendimento r = Rendimento.obterRendimento("Salario", 10000f, false);
		Deducao ded1 = Deducao.obterDeducao("Contribuição Previdenciaria", 1000f);
		Dependente dep1 = Dependente.obterDependente("Dependente 1", "111.111.111-11");
		c.cadastrarRendimento(r);
		c.cadastrarDeducao(ded1);
		c.cadastrarDependente(dep1);
		Imposto i = c.calcularImposto();
		
		assertEquals(1140.08f, i.getFaixa5(), 0.01f);
		assertEquals(205.57f,  i.getFaixa4(), 0.01f);
		assertEquals(138.66f,  i.getFaixa3(), 0.01f);
		assertEquals(69.20f,   i.getFaixa2(), 0.01f);
		assertEquals(0.0f,     i.getFaixa1(), 0.01f);
	}

	@Test
	public void test2() {
		Contribuinte c = Contribuinte.obterContribuinte("Fulano de Tal", "000.000.000-00");
		
		Rendimento r = Rendimento.obterRendimento("Salario", 5000f, false);
		Deducao ded1 = Deducao.obterDeducao("Contribuição Previdenciaria", 700f);
		Dependente dep1 = Dependente.obterDependente("Dependente 1", "111.111.111-11");
		Dependente dep2 = Dependente.obterDependente("Dependente 2", "222.222.222-22");
		c.cadastrarRendimento(r);
		c.cadastrarDeducao(ded1);
		c.cadastrarDependente(dep1);
		c.cadastrarDependente(dep2);
		Imposto i = c.calcularImposto();
		
		assertEquals(0f, i.getFaixa5(), 0.01f);
		assertEquals(38.20f,  i.getFaixa4(), 0.01f);
		assertEquals(138.66f,  i.getFaixa3(), 0.01f);
		assertEquals(69.20f,   i.getFaixa2(), 0.01f);
		assertEquals(0.0f,     i.getFaixa1(), 0.01f);
	}
	
	@Test
	public void test3() {
		Contribuinte c = Contribuinte.obterContribuinte("Fulano de Tal", "000.000.000-00");
		
		Rendimento r = Rendimento.obterRendimento("Salario", 8000f, false);
		Deducao ded1 = Deducao.obterDeducao("Contribuição Previdenciaria", 1400f);
		Dependente dep1 = Dependente.obterDependente("Dependente 1", "111.111.111-11");
		Dependente dep2 = Dependente.obterDependente("Dependente 2", "222.222.222-22");
		Dependente dep3 = Dependente.obterDependente("Dependente 3", "333.333.333-33");
		c.cadastrarRendimento(r);
		c.cadastrarDeducao(ded1);
		c.cadastrarDependente(dep1);
		c.cadastrarDependente(dep2);
		c.cadastrarDependente(dep3);
		Imposto i = c.calcularImposto();
		
		assertEquals(375.80f, i.getFaixa5(), 0.01f);
		assertEquals(205.57f,  i.getFaixa4(), 0.01f);
		assertEquals(138.66f,  i.getFaixa3(), 0.01f);
		assertEquals(69.20f,   i.getFaixa2(), 0.01f);
		assertEquals(0.0f,     i.getFaixa1(), 0.01f);
	}
}
