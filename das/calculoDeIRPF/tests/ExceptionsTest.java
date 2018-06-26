package tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import calculoDeIRPF.IRPF;
import exceptions.RendimentosNulosException;
import calculoDeIRPFExceptions.RendimentosVaziosException;
import tests.Categories.ExceptionsCategory;;


@Category(ExceptionsCategory.class)
public class ExceptionsTest {

	static IRPF irpf_variable;
	
	@BeforeClass
	public static void setup() {
		irpf_variable = new IRPF();
	}

	@Test(expected = RendimentosVaziosException.class)
	public void testCalcularBaseDeCalculo() throws RendimentosVaziosException, RendimentosNulosException {
		irpf_variable.calcularBaseDeCalculo();
	}
	
	@Test(expected = RendimentosNulosException.class)
	public void testTotalRendimento() throws RendimentosNulosException {
		irpf_variable.totalRendimentos();
	}

	
}