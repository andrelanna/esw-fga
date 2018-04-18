package calculoDeIRPF.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import calculoDeIRPF.IRPF;
import calculoDeIRPF.exceptions.RendimentosNulosException;
import calculoDeIRPF.exceptions.RendimentosVaziosException;

public class RendimentosVaziosTest {

	IRPF irpf;
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	@Test(expected = RendimentosVaziosException.class)
	public void testBaseDeCalculoSemRendimentos() throws RendimentosVaziosException {
		irpf.calcularBaseDeCalculo();
	}
	
	@Test(expected = RendimentosNulosException.class)
	public void testCalculoImpostoSemRendimentos() throws RendimentosNulosException {
		irpf.totalRendimentos();
	}

}
