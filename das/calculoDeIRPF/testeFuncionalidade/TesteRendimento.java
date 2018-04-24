package testeFuncionalidade;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import calculoDeIRPF.Rendimento;
import categoriasTeste.CategoriaTesteFuncionalidade;

@RunWith(Parameterized.class)
@Category(CategoriaTesteFuncionalidade.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteRendimento {
	private String descricao;
	private float valor, resultadoEsperado;


	public TesteRendimento(String descricao, float valor, float resultadoEsperado) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.resultadoEsperado = resultadoEsperado;
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"Teste 01", 100f, 100f}, {"Teste 02", 200f, 200f}
		});
	}

	@Test
	public void testeRendimento() {
		float resultado = new Rendimento(descricao, valor).getValor();

		assertEquals(resultadoEsperado, resultado, 0);
	}
}
