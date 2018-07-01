package testeFuncionalidade;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import calculoDeIRPF.Deducao;
import calculoDeIRPF.IRPF;
import calculoDeIRPF.Rendimento;
import calculoDeIRPF.exceptions.RendimentosVaziosException;
import categoriasTeste.CategoriaTesteFuncionalidade;
import exceptions.RendimentosNulosException;


public class TesteIRPF {

	@Test
	@Category(CategoriaTesteFuncionalidade.class)
	public void testeCadastrarRendimento() {
		Rendimento rendimento = new Rendimento("Teste 01", 100f);
		IRPF irpf = new IRPF();
		
		assertTrue(irpf.cadastrarRendimento(rendimento));
	}
	
	@Test 
	@Category(CategoriaTesteFuncionalidade.class)
	public void testeTotalRendimento() throws RendimentosNulosException {
		Rendimento rendimento = new Rendimento("Teste", 100f);
		IRPF irpf = new IRPF();
		
		irpf.cadastrarRendimento(rendimento);
		
		assertEquals(100f, irpf.totalRendimentos(), 0);
	}
	
	@Test
	@Category(CategoriaTesteFuncionalidade.class)
	public void testeNumRendimentos() {
		Rendimento rendimento = new Rendimento("Teste", 100f);
		IRPF irpf = new IRPF();
		
		irpf.cadastrarRendimento(rendimento);
		
		assertEquals(1, irpf.numRendimentos());
	}
	
	@Test
	@Category(CategoriaTesteFuncionalidade.class)
	public void testeGetRendimentos() {
		Rendimento rendimento = new Rendimento("Teste", 100f);
		IRPF irpf = new IRPF();
		ArrayList resultadoEsperado = new ArrayList<>();
		resultadoEsperado.add(rendimento);
		
		irpf.cadastrarRendimento(rendimento);
		
		assertArrayEquals(resultadoEsperado.toArray(), irpf.getRendimentos());
	}
	
	@Test
	@Category(CategoriaTesteFuncionalidade.class)
	public void testeCadastrarDeducao() {
		Deducao deducao = new Deducao("Teste", 100f);
		IRPF irpf = new IRPF();
		
		assertTrue(irpf.cadastrarDedudacao(deducao));
		
	}
	
	@Test 
	@Category(CategoriaTesteFuncionalidade.class)
	public void testeTotalDeducao() throws RendimentosNulosException {
		Deducao deducao = new Deducao("Teste", 100f);
		IRPF irpf = new IRPF();
		
		irpf.cadastrarDedudacao(deducao);
		
		assertEquals(100f, irpf.totalDeducoes(), 0);
	}
	
	@Test
	@Category(CategoriaTesteFuncionalidade.class)
	public void testeNumDeducao() {
		Deducao deducao = new Deducao("Teste", 100f);
		IRPF irpf = new IRPF();
		
		irpf.cadastrarDedudacao(deducao);
		
		assertEquals(1, irpf.numTotalDeducoes());
	}
	
	@Test
	@Category(CategoriaTesteFuncionalidade.class)
	public void testeCalcularBaseCalculo() throws RendimentosVaziosException {
		Rendimento rendimento = new Rendimento("Teste", 100f);
		Rendimento rendimento2 = new Rendimento("Teste2", 200f);
		IRPF irpf = new IRPF();
		
		irpf.cadastrarRendimento(rendimento);
		irpf.cadastrarRendimento(rendimento2);
		
		assertEquals(300f, irpf.calcularBaseDeCalculo(), 0);
	}
	
}
