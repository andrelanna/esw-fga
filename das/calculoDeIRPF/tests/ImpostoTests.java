package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import calculoDeIRPF.*;


public class ImpostoTests {
	
	
	@Test
	public void testDadosCorretosDoImpostoPoremDeducaoMaiorQueTotal(){
		
		try {
			Imposto i = new Imposto(10,10,1000);
			assertEquals(i.valorImposto(), 0f, 0.001f);
			
		} catch(Exception e){
			fail("Tax Test Failed.");
		}
	}
	
	@Test
	public void testDadosCorretosDoImpostoPoremDeducaoMenorQueTotal(){
		
		try {
			Imposto i = new Imposto(10,100,10);
			assertEquals(i.valorImposto(), 80f, 0.001f);
			
		} catch(Exception e){
			fail("Tax Test Failed.");
		}
	}
	
	@Test
	public void testDadosCorretosDoImpostoDeducaoZero(){
		
		try {
			Imposto i = new Imposto(10,100,0);
			assertEquals(i.valorImposto(), 90f, 0.001f);
			
		} catch(Exception e){
			fail("Tax Test Failed.");
		}
	}
	
	
	@Test(expected = Exception.class)
	public void testImpostoComDadosErrados() throws Exception {
		new Imposto(-1, 10, 10);
	}

}
