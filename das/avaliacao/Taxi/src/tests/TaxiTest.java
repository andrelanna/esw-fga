package taxi;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.JUnit4;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import taxi.Taxi; 

@RunWith(Parameterized.class)
class TaxiTest {
	
	static Taxi taxi;
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        	{ 1, 100, 0, 290.24}, 
        	{ 2, 100, 0, 371.24},
        	{ 1, 50 , 1, 179.46},
        	{ 2, 50 , 1, 219.96},
        	{ 1, 30 , 2, 154.18},
        	{ 2, 30 , 2, 178.48}
        });
    }
    
    @Parameter
    public int bandeira;
    
    @Parameter(1)
    public int kmRodados;
    
    @Parameter(2)
    public int numHorasParadas;
    
    @Parameter(3)
    public double tarifaDeTaxi;

	@BeforeClass
	public static void setUp() throws Exception {
		taxi = new Taxi();
	}

	@Test
	void testTarifaDeTaxiCalculada() {
		double tarifaDeTaxiCalculada = taxi.calcularTarifaDeTaxi(bandeira, kmRodados, numHorasParadas);
		assertEquals(tarifaDeTaxiCalculada, this.tarifaDeTaxi, 0f);
	}
	
	@Test(expected = BandeiraException.class)
	public void testTarifaDeTaxiCalculadaComBandeiraInvalida() throws BandeiraException {
		taxi.calcularTarifaDeTaxi(0, kmRodados, numHorasParadas);
	}
	
	@Test(expected = KMException.class)
	public void testTarifaDeTaxiCalculadaComBandeiraInvalida() throws KMException {
		taxi.calcularTarifaDeTaxi(1, 0, numHorasParadas);
	}
	

}
