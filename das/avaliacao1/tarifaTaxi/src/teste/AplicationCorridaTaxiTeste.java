package teste;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.awt.List;
import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import taxi.ValorCorridaTaxi;

@RunWith(Parameterized.class)
public class AplicationCorridaTaxiTeste {
	
	 @Parameter
     private double[] quadrado = new double[0];
 
     @Parameter(value = 1)
     private double esperado;
	
	 @Parameters
     public static Collection<Object[]> data() {
          return Arrays.asList(new Object[][] {
               {Arrays.asList(5.24, 100, 2.85, 0, 31,72), 290.24}, 
               {Arrays.asList(5.24, 100, 3.66, 0, 31,72), 371.24},
               {Arrays.asList(5.24, 50, 2.85, 1, 31,72), 179.46}, 
               {Arrays.asList(5.24, 50, 3.66, 1, 31,72), 219.96},
               {Arrays.asList(5.24, 30, 2.85, 2, 31,72), 154.18}, 
               {Arrays.asList(5.24, 30, 3.66, 2, 31,72), 178.48}
          });
 
     }
	
	/*
	• Bandeira 1, 100km, 0 hora parada
	• Bandeira 2, 100km, 0 hora parada
	• Bandeira 1, 50km, 1 hora parada
	• Bandeira 2, 50km, 1 hora parada
	• Bandeira 1, 30km, 2 horas paradas
	• Bandeira 2, 30km, 2 horas paradas
	*/
	
	@Test
	public void test() {
		
		 assertEquals(esperado, new ValorCorridaTaxi().calcValorTaxi(quadrado), 0.2);
	}
	

}
