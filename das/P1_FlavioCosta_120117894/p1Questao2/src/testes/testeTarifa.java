package testes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import calculaTarifa.Tarifa;

@RunWith(Parameterized.class)
public class testeTarifa {

    public static Tarifa tarifa;

    private double valorEsperado;

    @BeforeClass
	public static void setup() {
		double km = 100;
		double hora = 0;
		tarifa = new Tarifa(km, hora);
	}
    
    public testeTarifa(double valor) {
    	valorEsperado = tarifa.valorCorridaB1(tarifa);
    }

    @Test
    public void testeBandeira1() {
        assertEquals(valorEsperado, Tarifa.valorCorridaB1());
    }
    
    @Test
    public void testeBandeira2() {
        assertEquals(valorEsperado, Tarifa.valorCorridaB2());
    }
    
    @Test
    public void testeBandeira1Erro() {
        assertNotEquals(valorEsperado, Tarifa.valorCorridaB1());
    }
    
    @Test
    public void testeBandeira2Erro() {
        assertNotEquals(valorEsperado, Tarifa.valorCorridaB2());
    }
    
    @Test
    public void testeBandeira1SemKm() {
        assertNotEquals(valorEsperado, Tarifa.valorCorridaB2());
    }
    
    @Test
    public void testeBandeira2SemKm() {
        assertNotEquals(valorEsperado, Tarifa.valorCorridaB2());
    }
    
    @Test
    public void testeBandeira1SemHora() {
        assertNotEquals(valorEsperado, Tarifa.valorCorridaB2());
    }
    
    @Test
    public void testeBandeira2SemHora() {
        assertNotEquals(valorEsperado, Tarifa.valorCorridaB2());
    }
}
