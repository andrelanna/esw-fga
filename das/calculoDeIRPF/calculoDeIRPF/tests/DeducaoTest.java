package calculoDeIRPF.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import calculoDeIRPF.Deducao;
import calculoDeIRPF.IRPF;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)
public class DeducaoTest {

	static IRPF irpf;
	Deducao deducao;
	float expected;
	int num;
	
	@BeforeClass
	public static void setup() {
		irpf = new IRPF();
	}
	
	public DeducaoTest(Deducao d, float expected, int num) {
		this.deducao = d;
		this.expected = expected;
		this.num = num;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{new Deducao("Contribuicao previdenciaria", 1000f), 1000f, 1},
			{new Deducao("Plano de saude", 300f), 1300f, 2},
			{new Deducao("Pensao Alimenticia", 600f), 1900f, 3},
			{new Deducao("Dependentes(2)", 379.18f), 2279.18f, 4},
		});
	}
	
	
	@Test
	public void testCadastroDeducaoParametrizado() {
		
		boolean resposta = irpf.cadastrarDedudacao(this.deducao);
		assertTrue(resposta); 
		assertEquals(this.expected, irpf.totalDeducoes(), 0f);
		assertEquals(this.num, irpf.numTotalDeducoes());
	}

}
