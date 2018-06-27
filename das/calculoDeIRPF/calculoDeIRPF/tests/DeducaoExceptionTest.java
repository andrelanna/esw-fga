package calculoDeIRPF.tests;

import org.junit.Before;
import org.junit.Test;

import calculoDeIRPF.Deducao;
import calculoDeIRPF.IRPF;
import calculoDeIRPF.exceptions.DeducaoNulaException;
import calculoDeIRPF.exceptions.DeducaoVaziaException;

public class DeducaoExceptionTest {

	IRPF irpf;
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	@Test(expected = DeducaoNulaException.class)
	public void testDeducaoNula() throws DeducaoNulaException {
		Deducao d = null;
		irpf.cadastrarDedudacao(d);
	}
	
	@Test(expected = DeducaoVaziaException.class)
	public void testDeducaoVazia() throws DeducaoVaziaException {
		irpf.totalDeducoes();
	}
	
}
