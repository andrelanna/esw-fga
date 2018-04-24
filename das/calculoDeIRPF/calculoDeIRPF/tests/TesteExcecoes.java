package calculoDeIRPF.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import calculoDeIRPF.IRPF;
import calculoDeIRPF.category.CategoriaException;
import calculoDeIRPF.exceptions.RendimentoException;
import calculoDeIRPF.exceptions.RendimentosNulosException;
import calculoDeIRPF.exceptions.RendimentosVaziosException;

@Category(CategoriaException.class)
public class TesteExcecoes {

	static IRPF irpf;
	
	@BeforeClass
	public static void setup() {
		irpf = new IRPF();
	}
	
	
	@Test(expected = RendimentoException.class)
	public void totalRendimentoExpception() throws RendimentoException {
		irpf.totalRendimentos();
	}
	
	@Test(expected = RendimentosVaziosException.class)
	public void calcularBaseDeCalculoExpception() throws RendimentosVaziosException, RendimentosNulosException {
		irpf.calcularBaseDeCalculo();
	}
	
}
