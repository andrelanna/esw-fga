package calculoDeIRPF.tests;

import org.junit.Before;
import org.junit.Test;

import calculoDeIRPF.IRPF;
import calculoDeIRPF.Imposto;
import calculoDeIRPF.exceptions.ImpostoSizeException;

public class ImpostoExceptionTest {
	IRPF irpf;
	
	@Before
	public void setUp() {
		irpf = new IRPF();
	}
	
	@Test(expected = ImpostoSizeException.class)
	public void testImpostoSizeException() throws ImpostoSizeException {
		Imposto imp = new Imposto(1,2,3);
		irpf.cadastrarImposto(imp);
		irpf.cadastrarImposto(imp);
		irpf.cadastrarImposto(imp);
		irpf.cadastrarImposto(imp);
		irpf.cadastrarImposto(imp);
		irpf.cadastrarImposto(imp);
		irpf.numImposto();
	}
}
