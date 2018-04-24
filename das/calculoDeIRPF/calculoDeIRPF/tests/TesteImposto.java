package calculoDeIRPF.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import calculoDeIRPF.IRPF;
import calculoDeIRPF.category.CategoriaImposto;
import calculoDeIRPF.exceptions.RendimentosNulosException;
import calculoDeIRPF.exceptions.RendimentosVaziosException;

@RunWith(Parameterized.class)
@Category(CategoriaImposto.class)
public class TesteImposto {
	
	IRPF irpf; 
	ArrayList<Float> valores;
	float valorTotal;
	float baseCalculo;


	public TesteImposto(ArrayList<Float> valores, float baseCalculo, float valorTotal) {
		this.valores = valores;
		this.valorTotal = valorTotal;
		this.baseCalculo = baseCalculo;
	}

	@Before
	public void setup() {
		this.irpf = new IRPF();
	}

	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{new ArrayList<Float>(Arrays.asList(0.00f, 69.20f, 138.66f, 205.57f, 1192.21f)), 9000.00f, 1605.64f},
			{new ArrayList<Float>(Arrays.asList(0f, 69.20f, 26f, 0f, 0f)), 3000.00f, 95.20f},
			{new ArrayList<Float>(Arrays.asList(0f, 0f, 0f, 0f, 0f)), 1f, 0f}
		});
	}
	
	@Test
	public void testImposto() throws RendimentosVaziosException, RendimentosNulosException {
		irpf.setBaseDeCalculo(this.baseCalculo);
		assertEquals(this.valorTotal, irpf.totalImposto(), 0.1f);
		for(int i = 0; i < 5; i++) {
			assertEquals(valores.get(i), irpf.getImpostos().get(i).getValorImposto(), 0.1f);
		}
	}

}
