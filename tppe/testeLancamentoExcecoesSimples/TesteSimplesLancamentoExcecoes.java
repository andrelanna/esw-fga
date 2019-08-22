package testeLancamentoExcecoesSimples;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteSimplesLancamentoExcecoes {

	@Test(expected = MedidaNegativaOuNulaException.class)
	public void test() throws MedidaNegativaOuNulaException {
		Triangulo t = Triangulo.obterTriangulo(3, -1, 5);
	}
	
	@Test
	public void test2() throws MedidaNegativaOuNulaException {
		Triangulo t = Triangulo.obterTriangulo(3, 4, 5);
		assertNotNull(t);
	}

}
