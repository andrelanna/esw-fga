package tests;

import static org.junit.Assert.*; 

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;

import aplicacao.IRPF;
import aplicacao.Rendimento;
import exceptions.RendimentosNulosException;

import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@FixMethodOrder(MethodSorters.JVM)
public class RendimentoTest {

	static IRPF irpf;
	
	@BeforeClass
	public static void setup() {
		irpf = new IRPF();
	}
	

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void test0opasso_AcessarRendimentoNaoCadastrado() {
		Object[] rends = irpf.getRendimentos();
		Object r = rends[0];
	}
	
	
	@Test
	public void test2opasso_CadastrarRendimentoDuplicado() throws RendimentosNulosException {
		String descricao = "Salario"; 
		float valor = 3000f;
		
		System.out.println(2 + " " + irpf);
		Rendimento r = new Rendimento(descricao, valor);
		
		assertTrue(irpf.cadastrarRendimento(r));
		assertEquals(8000f, irpf.totalRendimentos(), 0f);
		assertEquals(1, irpf.numRendimentos());
	}
	
	@Test
	public void test1opasso_CadastroRendimentoUnico() throws RendimentosNulosException {
		String descricao = "Salario";
		float valor = 5000f;
		
		Rendimento r = new Rendimento(descricao, valor); 
		
		System.out.println(1 + " " + irpf);
		assertTrue(irpf.cadastrarRendimento(r));
		assertEquals(5000f, irpf.totalRendimentos(), 0f);
		assertEquals(1, irpf.numRendimentos());
	}
	
	@Test
	public void test3opasso_CadastroAluguel() throws RendimentosNulosException {
		String descricao = "Aluguel"; 
		float valor = 1000f;
		
		Rendimento r = new Rendimento(descricao, valor); 
		
		System.out.println(3 + " " + irpf);
		assertTrue(irpf.cadastrarRendimento(r));
		assertEquals(9000f, irpf.totalRendimentos(), 0f);
		assertEquals(2, irpf.numRendimentos());
	}

}
