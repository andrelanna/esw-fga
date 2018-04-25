package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import calculoDeIRPF.Deducao;
import calculoDeIRPF.IRPF;
import calculoDeIRPF.exceptions.ImpostoNuloException;
import calculoDeIRPF.exceptions.RendimentosNulosException;

public class ImpostoTest {
	
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

	@Test(expected = ImpostoNuloException.class)
	public void testCalculoImpostoSemRendimentos() throws ImpostoNuloException {
		//irpf.calculaImposto();
	}

	
}
