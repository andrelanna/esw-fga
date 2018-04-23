package testeExcecao;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import calculoDeIRPF.IRPF;
import calculoDeIRPF.exceptions.RendimentosVaziosException;
import categoriasTeste.CategoriaTesteExcecao;
import exceptions.RendimentosNulosException;

public class TesteExcecao {

	@Test(expected=RendimentosNulosException.class)
	@Category(CategoriaTesteExcecao.class)
	public void testeRendimentoNuloException() throws RendimentosNulosException {
		IRPF irpf = new IRPF();
		irpf.totalRendimentos();
	}
	
	@Test(expected=RendimentosVaziosException.class)
	@Category(CategoriaTesteExcecao.class)
	public void testeRendimentoVazioException() throws RendimentosVaziosException {
		IRPF irpf = new IRPF();
		irpf.calcularBaseDeCalculo();
	}
	
}