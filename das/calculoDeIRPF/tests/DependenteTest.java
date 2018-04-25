package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import calculoDeIRPF.Dependente;
import calculoDeIRPF.IRPF;

public class DependenteTest {

static IRPF irpf; 
	
	@BeforeClass
	public static void setup() {
		irpf = new IRPF();
	}
	
	
	@Test
	public void testCadastraPrimeiroDependente() {
		Dependente d = new Dependente("Joao Mariano", 
				                "Masculino");
		
		boolean resposta = irpf.cadastrarDependente(d);
		assertEquals(1, irpf.numTotalDependentes());
		assertTrue(resposta);
	}
	
	@Test
	public void testCadastraSegundoDependente() {
		Dependente d = new Dependente("Ana Maria", 
				                "Feminino");
		
		boolean resposta = irpf.cadastrarDependente(d);
		assertEquals(2, irpf.numTotalDependentes());
		assertTrue(resposta);
	}
}
