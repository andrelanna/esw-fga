package testeFuncionalidade;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import calculoDeIRPF.Deducao;
import categoriasTeste.CategoriaTesteFuncionalidade;

@RunWith(Parameterized.class)
@Category(CategoriaTesteFuncionalidade.class)
public class TesteDeducao {
	private String descricao;
	private float valor, valorEsperado;
	static Deducao deducao;


	public TesteDeducao(String descricao, float valor, float valorEsperado) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.valorEsperado = valorEsperado;
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"Teste 01", 100f, 100f}, {"Teste 02", 200f, 200f}
		});
	}

	@Test
	public void testeDeducao() {
		float resultado = new Deducao(descricao, valor).getValor();
		assertEquals(this.valorEsperado, resultado, 0);
	}

}
