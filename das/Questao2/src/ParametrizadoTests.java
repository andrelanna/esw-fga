import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.MethodSorters;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)
public class ParametrizadoTests {
	
	int a;
	double b, c, esperado;
	@Before
	public void initialization(){
		
	}
	
	public ParametrizadoTests(int a, double b, double c, double esperado) {
		this.a = a;
		this.b = b;
		this.c =c;
		this.esperado = esperado;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			 {1, 100.0, 0.0, 290.24}, {2, 100f, 0f, 371.24}, {1, 50f, 1f, 179.46}, {2, 50f, 1f, 219.96}, {1, 30f, 2f, 154.18}, {2, 30f, 2f, 178.48000000000002}
		});
	}
	
	@Test
	public void Test() throws KMExceptions, BandeiraException{
		Corrida corrida = new Corrida(a, b, c);
		assertEquals(esperado, corrida.GetValue(), 0.0f);
	}
}
