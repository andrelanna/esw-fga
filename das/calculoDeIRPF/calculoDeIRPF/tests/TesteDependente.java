package calculoDeIRPF.tests;

import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;

import calculoDeIRPF.Dependente;
import calculoDeIRPF.IRPF;
import calculoDeIRPF.exceptions.RendimentosNulosException;
import calculoDeIRPF.exceptions.RendimentosVaziosException;

@RunWith(Parameterized.class)
public class TesteDependente {
	
	static IRPF irpf; 
	float valorTotal;
	int quantidade;
	Dependente dependente;
	
	@Mock
	static Dependente dependente1;
	
	@Mock
	static Dependente dependente2;
	
	@Mock
	static Dependente dependente3;
	
	@Mock
	static Dependente dependente4;
	
	
	public TesteDependente(Dependente dependente, int quantidade, float valorTotal) {
		this.dependente = dependente;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
	}

	@BeforeClass
	public static void setup() {
		irpf = new IRPF();
	}
	
	@Before
	public void inicializarMock() {
		initMocks(this);
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{dependente1, 1, 189.59f},
			{dependente2, 2, 379.18f},
			{dependente3, 3, 568.77f},
			{dependente4, 4, 758.36f},
		});
	}
	
	@Test
	public void testCadastroDeducao() throws RendimentosVaziosException, RendimentosNulosException {
		boolean resposta = irpf.adicionarDependente(this.dependente);
		assertTrue(resposta);
		assertEquals(this.valorTotal, irpf.totalDependentes(), 0.1f);
		assertEquals(this.quantidade, irpf.getDependentes().size());
	}
}

