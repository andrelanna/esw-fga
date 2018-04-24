package testeFuncionalidade;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import calculoDeIRPF.Imposto;

@RunWith(Parameterized.class)
public class TesteImposto {
	private float aliquota;
	private float baseCalculo;
	private float valorImpostoEsperado;

	public TesteImposto(float aliquota, float baseCalculo, float valorImpostoEsperado) {
		this.aliquota = aliquota;
		this.baseCalculo = baseCalculo;
		this.valorImpostoEsperado = valorImpostoEsperado;
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{ 0.01f, 2000f, 20f },
			{ 0.02f, 4000f, 80f },
			{ 0.025f, 4000f, 100f },
			{ 0.07f, 40000f, 2800 },
		});
	}

	@Test
	public void testGetValorImposto() {
		Imposto imposto = new Imposto(this.aliquota, this.baseCalculo);
		float valorImposto = imposto.getValorImposto();

		assertEquals(this.valorImpostoEsperado, valorImposto, 0f);
	}

}
