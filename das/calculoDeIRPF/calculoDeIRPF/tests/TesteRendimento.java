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

import calculoDeIRPF.IRPF;
import calculoDeIRPF.Rendimento;
import calculoDeIRPF.exceptions.RendimentosNulosException;

@RunWith(Parameterized.class)
public class TesteRendimento {
	
	static IRPF irpf; 
	String descricao;
	float valor;
	float valorTotal;
	int total;
	
	public TesteRendimento(String descricao, float valor, float valorTotal, int total) {
		this.descricao = descricao;
		this.valor = valor;
		this.valorTotal = valorTotal;
		this.total = total;
	}

	@BeforeClass
	public static void setup() {
		irpf = new IRPF();
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{"Primeiro rendimento", 100.0f, 100.0f, 1},
			{"Segundo rendimento", 1000.0f, 1100.0f, 2},
			{"Terceiro rendimento", 500.0f, 1600.0f, 3},
			{"Quarto rendimento", 10.0f, 1610.0f, 4}
		});
	}
	
	@Test
	public void testCadastroRendimento() throws RendimentosNulosException {
		Rendimento r = new Rendimento(this.descricao, this.valor);
		
		boolean resposta = irpf.cadastrarRendimento(r);
		assertTrue(resposta); 
		assertEquals(this.valorTotal, irpf.totalRendimentos(), 0.1f);
		assertEquals(this.total, irpf.numRendimentos());
	}

}
