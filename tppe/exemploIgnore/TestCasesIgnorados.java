package exemploIgnore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestCasesIgnorados {

	CadastroVeiculos c; 
	
	@Before
	public void setup() {
		c = CadastroVeiculos.obterCadastroVeiculos();
	}
	
	@Test
	public void testCadastrarVeiculosUnicamente() {
		Veiculo v = Veiculo.obterVeiculo("Vw", "Polo");
		assertTrue(c.cadastrarVeiculo(v));
		
		v = Veiculo.obterVeiculo("Honda", "Fit");
		assertTrue(c.cadastrarVeiculo(v));
		
		v = Veiculo.obterVeiculo("Vw", "Polo");
		assertFalse(c.cadastrarVeiculo(v));
	}
	
	@Test 
	public void testPesquisarVeiculo() {
		//Criacao e cadastro de veiculos
		Veiculo v1 = Veiculo.obterVeiculo("Vw", "Polo"),
				v2 = Veiculo.obterVeiculo("Honda", "Fit");
		c.cadastrarVeiculo(v1);
		c.cadastrarVeiculo(v2);
		
		//Teste busca por atributos
		Veiculo t1 = c.pesquisarVeiculo("Vw", "Polo");
		assertNotNull(t1);
		assertEquals("Vw", t1.getMarca());
		assertEquals("Polo", t1.getModelo());
		
		//Teste busca por objeto
		Veiculo t2 = c.pesquisarVeiculo("Fiat", "Palio");
		assertNull(t2);
	}
	
	@Ignore
	@Test
	public void testDeletarVeiculo() {
		System.out.println("Nem executa essa instrucao.");
	}

}
