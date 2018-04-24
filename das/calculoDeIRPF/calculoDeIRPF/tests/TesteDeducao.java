package calculoDeIRPF.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import calculoDeIRPF.Deducao;
import calculoDeIRPF.IRPF;

@RunWith(Parameterized.class)
public class TesteDeducao {
	
	static IRPF irpf; 
	String nomeDeducao;
	float valorDeducao;
	float valorTotal;
	int total;
	
	public TesteDeducao(String nomeDeducao, float valorDeducao, float valorTotal, int total) {
		this.nomeDeducao = nomeDeducao;
		this.valorDeducao = valorDeducao;
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
			{"Primeira dedução", 100.0f, 100.0f, 1},
			{"Segunda dedução", 1000.0f, 1100.0f, 2},
			{"Terceira dedução", 500.0f, 1600.0f, 3},
			{"Quarta dedução", 10.0f, 1610.0f, 4}
		});
	}
	
	@Test
	public void testCadastroDeducao() {
		Deducao d = new Deducao(this.nomeDeducao, this.valorDeducao);
		
		boolean resposta = irpf.cadastrarDedudacao(d);
		assertTrue(resposta); 
		assertEquals(this.valorTotal, irpf.totalDeducoes(), 0.1f);
		assertEquals(this.total, irpf.numTotalDeducoes());
	}

}
