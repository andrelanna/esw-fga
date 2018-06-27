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
import calculoDeIRPF.Imposto;
import calculoDeIRPF.exceptions.ImpostoSizeException;

@RunWith(Parameterized.class)
public class ImpostoTest {
	static IRPF irpf;
	Imposto imposto;
	int num;
	
	@BeforeClass
	public static void setup() {
		irpf = new IRPF();
	}
	
	public ImpostoTest(Imposto i, int num) {
		this.imposto = i;
		this.num = num;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{new Imposto(1000f, 1000f, 500f), 1},
			{new Imposto(4000f, 500f, 300f), 2},
			{new Imposto(250f, 100f, 40f), 3},
			{new Imposto(1800f, 900f, 500f), 4},
		});
	}
	
	
	@Test
	public void testCadastroImpostoParametrizado() throws ImpostoSizeException {
		
		boolean resposta = irpf.cadastrarImposto(this.imposto);
		assertTrue(resposta); 
		assertEquals(this.num, irpf.numImposto());
	}
}
