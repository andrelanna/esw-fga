package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import calculoDeIRPF.*;


@RunWith(Parameterized.class)
public class ImpostoTests {
	
	@Parameter(value = 0)
	public float aliquota;
	
	@Parameter(value = 1)
	public float baseCalc; 
	
	@Parameter(value = 2)
	public float deducao; 
	
	@Parameter(value = 3)
	public float expected;
	
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10f, 10f, 1000f, 0f},
                {10f, 100f, 10f, 80f},
                {10f, 100f, 0f, 90f},
                {40f, 100f, 0f, 60f},
                {10f, 200f, 0f, 180f},
                {0f, 0f, 0f, 0f},
        });
    }
	
	@Test
	public void testDadosCorretosDoImpostoDeducaoZero(){
		
		try {
			Imposto i = new Imposto(aliquota, baseCalc, deducao);
			assertEquals(i.valorImposto(), expected, 0.001f);
			
		} catch(Exception e){
			fail("Tax Test Failed.");
		}
	}

}
