package testes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import categoriasTeste.CategoriaSoma;
import exemplo2.MathApplication;

@RunWith(Parameterized.class)
@Category(CategoriaSoma.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteAdd {
	static double v1, v2, resultadoEsperado;
	static MathApplication mathApplication;
	
	public TesteAdd(double v1, double v2, double resultadoEsperado) {
		this.v1 = v1;
		this.v2 = v2;
		this.resultadoEsperado = resultadoEsperado;
	}	
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{1, 1, 2}, {2, 2, 4}, {-2, -2, -4}, {0, 2, 2}, {-1, 2, 1}, {2, -3, -1}, {0, 0, 0}
		});
	}
	
	@BeforeClass
	public static void setup() {
		mathApplication = new MathApplication();
	}
		
	
	@Test
	public void testAdd() {
		assertEquals(resultadoEsperado, mathApplication.add(v1, v2), 0);
	}

}
