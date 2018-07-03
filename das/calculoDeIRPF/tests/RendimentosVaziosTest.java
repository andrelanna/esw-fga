package tests;


import org.junit.Before;
import org.junit.Test;

import calculoDeIRPF.*;
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
	
	@Test(expected = RendimentosVaziosException.class)
	public void testCalculoImpostoSemRendimentos() throws RendimentosVaziosException {
		irpf.totalRendimentos();
	}

}
