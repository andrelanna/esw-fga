package taxi;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class corridaTest {
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			/*	{1,100,0,290.24},{2,100,0,371.24},
				{1,50,0,290.24},{2,50,0,371.24},
				{1,30,0,290.24},{2,30,0,371.24},*/
				{290.24,100}
		});
	}
	
	private int bandeira;
	private double fInput;
	private double fKm;
	private double fNumHorasParadas;
	private double fExpected;
	
	public corridaTest(double input, int expected){
		fInput = input;
		//fKm = km;
		//fNumHorasParadas = numHorasParadas;
		fExpected = expected;
	}
	
	@Test
	public void test() {
		assertEquals(fExpected, corrida.bandeira1calculaKm(fInput), 0.1f);
	}
	/*
	public void allTest(){
		assertEquals(fExpected, corrida.calculaCorrida(bandeira, fKm, fNumHorasParadas), 0.1f);
	}
*/
}
