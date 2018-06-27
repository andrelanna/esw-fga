package calculoDeIRPF.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import calculoDeIRPF.IRPF;
import calculoDeIRPF.Rendimento;
import calculoDeIRPF.exceptions.RendimentosNulosException;


@RunWith(Parameterized.class)
public class RendimentoTest {

	static IRPF irpf;
	Rendimento r;
	float expected;
	int num;
	
	@BeforeClass
	public static void setup() {
		irpf = new IRPF();
	}
	
	public RendimentoTest(Rendimento r, float expected, int num) {
		this.r = r;
		this.expected = expected;
		this.num = num;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{new Rendimento("Salario", 5000f), 5000f, 1},
			{new Rendimento("Aluguel", 1500f), 6500f, 2},
			{new Rendimento("Reembolo de Despesas", 1000f), 7500f, 3},
		});
	}
	
	@Test
	public void testCadastroRendimentoParametrizado() throws RendimentosNulosException { 
		
		assertTrue(irpf.cadastrarRendimento(this.r));
		assertEquals(this.expected, irpf.totalRendimentos(), 0f);
		assertEquals(this.num, irpf.numRendimentos());
	}

}
