package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import aplicacao.Deducao;
import aplicacao.IRPF;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeducaoTest {

	static IRPF irpf; 
	
	@BeforeClass
	public static void setup() {
		irpf = new IRPF();
	}
	
	
	@Test
	public void testCadastroPrimeiraDeducao() {
		Deducao d = new Deducao("Contribuicao previdenciaria", 
				                2000f);
		
		boolean resposta = irpf.cadastrarDedudacao(d);
		assertTrue(resposta); 
		assertEquals(2000f, irpf.totalDeducoes(), 0f);
		assertEquals(1, irpf.numTotalDeducoes());
	}
	
	@Test 
	public void testCadastroSegundaDeducao() {
		Deducao d = new Deducao("Plano de Saude", 
				                500f);
		
		boolean resposta = irpf.cadastrarDedudacao(d);
		assertTrue(resposta);
		assertEquals(2500f, irpf.totalDeducoes(), 0f);
		assertEquals(2, irpf.numTotalDeducoes());
	}

}
