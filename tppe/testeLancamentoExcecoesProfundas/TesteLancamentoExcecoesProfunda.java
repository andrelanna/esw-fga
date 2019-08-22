package testeLancamentoExcecoesProfundas;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.TypeSafeMatcher.*;

public class TesteLancamentoExcecoesProfunda {

	@Rule
	public ExpectedException ex = ExpectedException.none();
	
	@Test
	public void test() throws MedidaNegativaOuNulaException {
		ex.expect(MedidaNegativaOuNulaException.class);
		ex.expectMessage("A medida informada para o lado l2 é inválida: 0.0");

		Triangulo t1 = Triangulo.obterTriangulo(3, 0, 2);
	}
}
