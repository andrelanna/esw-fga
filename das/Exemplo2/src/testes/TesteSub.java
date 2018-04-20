package testes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


import exemplo2.CalculatorService;
import exemplo2.MathApplication;

@RunWith(MockitoJUnitRunner.class)
public class TesteSub {

	@InjectMocks
	MathApplication mathApplication = new MathApplication();
	
	@Mock
	CalculatorService calculatorService;
	
	@Test
	public void testeSubDoisNumDiferentesPositivos() {
		mathApplication.setCalcService(calculatorService);
		
		when(calculatorService.sub(10, 5)).thenReturn(5.0);
		
		assertEquals(5.0, mathApplication.sub(10, 5), 0);
	}
	
	@Test
	public void testeSubDoisNumIguais() {
		mathApplication.setCalcService(calculatorService);
		
		when(calculatorService.sub(10, 10)).thenReturn(0.0);
		
		assertEquals(0.0, mathApplication.sub(10, 10), 0);
		
	}
	
	@Test
	public void testeSubDoisNumDiferentesNegativos() {
		mathApplication.setCalcService(calculatorService);
		
		when(calculatorService.sub(-2, -4)).thenReturn(2.0);
		
		assertEquals(2.0, mathApplication.sub(-2, -4), 0);
	}
}
