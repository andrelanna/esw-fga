package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import calculoDeIRPF.IRPF;
import exceptions.RendimentosNulosException;
import tests.Categories.ExceptionsCategory;
import tests.Categories.RendimentoCategory;
import org.mockito.Mock;
import calculoDeIRPFExceptions.RendimentosVaziosException;

@Category(ExceptionsCategory.class)
public class RendimentosVaziosTest {
	@Mock
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
