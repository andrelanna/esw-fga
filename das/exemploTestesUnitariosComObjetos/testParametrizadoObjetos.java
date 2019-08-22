package exemploTestesUnitariosComObjetos;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class testParametrizadoObjetos {
	int a1,
		r, 
		n, 
		soma;
	int[] pa;
	
	public testParametrizadoObjetos(int a1, 
									int r,
									int n, 
									ResultadoEsperado re) {
		this.a1 = a1;
		this.r = r;
		this.n = n; 
		this.soma = re.getSoma();
		this.pa = re.getPa();
	}
	
	@Parameters
	public static Iterable getParameters() {
		Object[][] parametros = new Object[][] {
			{1, 2, 5, new ResultadoEsperado(
					new int[]{1, 3, 5, 7, 9}, 25) },
			{0, 3, 4, new ResultadoEsperado(
					new int[]{0, 3, 6, 9}, 18)},
			{2, 1, 6, new ResultadoEsperado(
					new int[]{2, 3, 4, 5, 6, 7}, 27)}
		};
		return Arrays.asList(parametros);
	}
	
	@Test
	public void test() {
		PA pa = PA.getPA(a1, r, n);
		
		assertArrayEquals(this.pa, pa.getTermos());
		assertEquals(this.soma, pa.getSoma());
	}

}
