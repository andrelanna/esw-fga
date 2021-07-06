package calculoTarifa.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import calculoDeTarifa.CalculoTarifa;
import calculoTarifa.exception.BandeiraException;
import calculoTarifa.exception.KMException;


@RunWith(Parameterized.class)
public class CalculaTarifasTest {

	public static CalculoTarifa calculoTarifa; 
	
	@BeforeClass
	public static void setup() {
		calculoTarifa = new CalculoTarifa();
	}
	
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { "Bandeira 1", 100,0,290.24}, { "Bandeira 2", 100, 0,371.24 }
                 //, { "Bandeira 1", 50, 1 }, { "Bandeira 2", 50, 1 }, { "Bandeira 1", 30,2 }, { "Bandeira 2", 30,2 }  
           });
    }
    
    private String fInputBandeira;
    private int fInputKM;
    private int fInputHora;
    private float fExpected;

    public CalculaTarifasTest(String inputBandeira,int inputKM, int inputHora, float expected) {
    	fInputBandeira =  inputBandeira;
    	fInputKM= inputKM;
    	fInputHora = inputHora;
        fExpected= expected;
    }

    @SuppressWarnings("deprecation")
	@Test
    public void test() throws BandeiraException, KMException {
        assertEquals(fExpected, calculoTarifa.calculaValorTarifa(fInputBandeira,fInputKM,fInputHora));
    }
	

}
